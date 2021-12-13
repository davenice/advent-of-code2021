package com.niced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day5b {

    static class Point {
        int x;
        int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        static Point create(int x, int y) {
            return new Point(x, y);
        }

        @Override
        public String toString() {
            return "("+x+", "+y+")";
        }

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
    }

    class Grid {
        Map<Point, Integer> grid = new HashMap<>();

        public void increment(Point p) {
            Integer retrievedPoint = grid.get(p);
            if (retrievedPoint != null) {
                grid.put(p, retrievedPoint.intValue() + 1);
            } else {
                grid.put(p, 1);
            }
        }

        public void addLine(Point start, Point end) {
            // work out which axis is static and increment the other
            if (start.x == end.x) {
                int starty = Math.min(start.y, end.y);
                int endy = Math.max(start.y, end.y);
                for(int y = starty; y <= endy; y++) {
                    increment(Point.create(start.x, y));
                }
            } else if(start.y == end.y) {
                int startx = Math.min(start.x, end.x);
                int endx = Math.max(start.x, end.x);
                for(int x = startx; x <= endx; x++) {
                    increment(Point.create(x, start.y));
                }
            } else {
                int xIncrement = 1;
                if (start.x > end.x) xIncrement = -1;
                int yIncrement = 1;
                if (start.y > end.y) yIncrement = -1;

                int y = start.y;
                int x = start.x;
                increment(Point.create(x, y));
                do {
                    y += yIncrement;
                    x += xIncrement;
                    increment(Point.create(x, y));
                } while (x != end.x);

            }
        }

        public List<Point> getDangerousPoints() {
            return grid.entrySet().stream()
                .filter(entry -> (entry.getValue() > 1)) // filter just values greater than 1
                .map(entry -> entry.getKey()) // we just want the key
                .collect(Collectors.toList());
        }
    }

    Grid grid = new Grid();

    public int run(String filename) throws IOException {
        parseFile(filename);
        return grid.getDangerousPoints().size();
    }
    
    public void parseFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream(filename)));
        Pattern regex = Pattern.compile("(\\d+),(\\d+)\\s\\->\\s(\\d+),(\\d+)");
        String line;
        while ((line = reader.readLine()) != null) {
            Matcher m = regex.matcher(line);
            if (m.matches()) {
                if (m.groupCount() != 4) {
                    throw new RuntimeException("didn't have 4 coords: "+line);
                } else {
                    Point start = Point.create(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)));
                    Point end = Point.create(Integer.parseInt(m.group(3)), Integer.parseInt(m.group(4)));
                    grid.addLine(start, end);
                }
            }
        }
    }

}
