package com.niced;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day1b {

    public int method(String filename) throws IOException {

        List<String> lines = Utility.readFile(filename);
        List<Integer> integers = new ArrayList<>();
        for(String line : lines) {
            integers.add(Integer.parseInt(line));
        }
    
        int startOfLastTriple = integers.size() - 3;
        int previousInteger = Integer.MAX_VALUE;
        int biggerCount = 0;
        for(int posn = 0; posn <= startOfLastTriple; posn++) {
            int currentInteger = calculateNumberAtPosition(posn, integers);
            if(currentInteger > previousInteger) biggerCount++;
            previousInteger = currentInteger;
        }

        return biggerCount;
    }

    private int calculateNumberAtPosition(int posn, List<Integer> integers) {
        return integers.get(posn) + integers.get(posn + 1) + integers.get(posn + 2);
    }


}
