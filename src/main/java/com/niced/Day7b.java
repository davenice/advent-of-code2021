package com.niced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Day7b {

    public int run(String filename) throws IOException {
        int[] crabs = parseFile(filename);
        int increment = 1;
        int firstGuessMidpoint = calculateRoughMidpoint(crabs);
        // first check whether we need to be increasing from the midpoint, or decreasing
        int firstGuessTotal = calculateFuelCostToAlignAtPosition(crabs, firstGuessMidpoint);
        int secondGuessTotal = calculateFuelCostToAlignAtPosition(crabs, firstGuessMidpoint+1);
        if (secondGuessTotal > firstGuessTotal) increment = -1;

        // next move through the options until we find the best
        int lastTotal = firstGuessTotal;
        int thisNumber = firstGuessMidpoint;
        int thisTotal = firstGuessTotal;
        do {
            thisNumber += increment;
            thisTotal = calculateFuelCostToAlignAtPosition(crabs, thisNumber);
            if (thisTotal < lastTotal) {
                lastTotal = thisTotal;
            } else {
                return lastTotal;
            }
        } while (true);

    }

    int calculateFuelCostToAlignAtPosition(int[] crabs, int position) {
        return Arrays.stream(crabs).map(crab -> Day7b.calculateTriangularNumber(Math.abs(crab - position))).sum();
    }

    private static int calculateTriangularNumber(int i) {
        // where i=5, 5+4+3+2+1 - this gives triangular numbers - googled for this formula!
        return i*(i+1)/2;
    }

    private int calculateRoughMidpoint(int[] crabs) {
        Arrays.sort(crabs);
        return crabs[crabs.length/2];
    }
    
    public int[] parseFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream(filename)));
        String line = reader.readLine();
        int[] crabs = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
        return crabs;
    }

}
