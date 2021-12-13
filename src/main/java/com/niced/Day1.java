package com.niced;

import java.io.IOException;
import java.util.List;

public class Day1 {

    public int method(String filename) throws IOException {
        List<String> lines = Utility.readFile(filename);
        int biggerCount = 0;
        int previousInt = Integer.MAX_VALUE;
        for(String line : lines) {
            int currentInt = Integer.parseInt(line);
            if (currentInt > previousInt) biggerCount++;
            previousInt = currentInt;
        }
        return biggerCount;
    }
}
