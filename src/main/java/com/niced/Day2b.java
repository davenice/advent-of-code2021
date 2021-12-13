package com.niced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day2b {

    enum Direction {
        forward, down, up
    }

    class SubmarineGps {
        private int aim = 0;
        private int depth = 0;
        private int distance = 0;

        public void apply(Instruction instruction) {
            switch(instruction.direction) {
                case down:
                    aim += instruction.distance;
                break;
                case forward:
                    distance += instruction.distance;
                    depth += instruction.distance * aim;
                break;
                case up:
                aim -= instruction.distance;
                break;
                default:
                    throw new RuntimeException("Invalid direction: "+instruction.direction);
            }
        }

        public int calculate() {
            return depth * distance;
        }
    }

    static class Instruction {
        public static Instruction build(Direction direction, int distance) {
            Instruction i = new Instruction();
            i.direction = direction;
            i.distance = distance;
            return i;
        }

        Direction direction;
        int distance;

        private Instruction(){};

    }

    public int run(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream(filename)));
        SubmarineGps gps = new SubmarineGps();
        String line;
        while ((line = reader.readLine()) != null) {
            Instruction instruction = parseLine(line);
            gps.apply(instruction);
        }
        return gps.calculate();
    }

    public static Instruction parseLine(String line) {
        String[] elements = line.split("\\s");
        if (elements.length != 2) throw new RuntimeException("Invalid line: "+line);
        Instruction instruction = Instruction.build(Direction.valueOf(elements[0]), Integer.parseInt(elements[1]));
        return instruction;
    }

}
