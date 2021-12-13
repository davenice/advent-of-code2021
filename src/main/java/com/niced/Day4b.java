package com.niced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day4b {

    int[] bingoCalls;
    List<BingoGrid> bingoGrids = new ArrayList<BingoGrid>();

    class BingoGrid {
        static final int CALLED = -1;
        int size = -1;
        List<Integer> numbers = new ArrayList<>();

        public void addRow(List<Integer> row) {
            if (size != -1) {
                if(row.size() != size) throw new RuntimeException("Mismatched row length");
            } else {
                size = row.size();
            }
            numbers.addAll(row);
        }

        public void call(int number) {
            if(numbers.contains(number)) {
                int index = numbers.indexOf(number);
                numbers.set(index, CALLED);
            }
        }

        public boolean isWinner() {
                return checkRows() || checkColumns();
        }

        boolean checkRows() {
            int calledCount = 0;
            for (int row=0; row < size; row++) {
                calledCount = 0;
                for (int col=0; col < size; col++) {
                    if(numbers.get((size*row) + col) == CALLED) {
                        calledCount++;
                    }
                }
                if (calledCount == size) return true;
            }
            return false;
        }

        boolean checkColumns() {
            int calledCount = 0;
            for (int col=0; col < size; col++) {
                calledCount = 0;
                for (int row=0; row < size; row++) {
                    if(numbers.get((size*row) + col) == CALLED) {
                        calledCount++;
                    }
                }
                if (calledCount == size) return true;
            }
            return false;
        }

        int countUnmarked() {
            return numbers.stream().filter(num -> num != -1).reduce(Integer::sum).get();
        }
    }

    public void call(int number) {
        bingoGrids.stream().forEach(grid -> grid.call(number));
    }

    public int run(String filename) throws IOException {
        parseFile(filename);
        for (int call : bingoCalls) {
            call(call);
            List<BingoGrid> toRemove = new ArrayList<>();
            for (BingoGrid grid : bingoGrids) {
                if(grid.isWinner()) {
                    if (bingoGrids.size() == 1) {
                        return grid.countUnmarked() * call;
                    } else {
                        toRemove.add(grid);
                    }
                }                
            }
            if (!toRemove.isEmpty()) bingoGrids.removeAll(toRemove);
}
        return -1;
    }
    
    public void parseFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream(filename)));
        String calls = reader.readLine();
        bingoCalls = Arrays.asList(calls.split(",")).stream().mapToInt(Integer::parseInt).toArray();
        String line;
        BingoGrid grid = null;
        while ((line = reader.readLine()) != null) {
            if (line.trim().length() == 0) {
                // if it's blank line then call that the end of a grid
                if(grid != null) bingoGrids.add(grid);
                grid = new BingoGrid();
            } else {
                // for each line, add to the existing grid
                String[] stringArray = line.trim().split("\\s+");
                grid.addRow(Arrays.asList(stringArray).stream().mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));
            }
        }
        // add the last grid
        bingoGrids.add(grid);     
    }

}
