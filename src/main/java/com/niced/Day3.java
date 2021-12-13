package com.niced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day3 {

    class DiagnosticReport {
        int reportCount = 0;
        int[] counts = null;

        public void apply(String reportEntry) {
            reportCount++;
            if (counts == null) {
                counts = new int[reportEntry.length()];
            }
            for(int i=0; i < counts.length; i++) {
                char character = reportEntry.charAt(i);
                if (character == '1') {
                    counts[i]++;
                } else if (character == '0') {
                    // do nothing
                } else {
                    throw new RuntimeException("Unrecognised character: "+character);
                }
            }
        }

        private int getGammaRate() {
            String gammaRateBinary = "";
            for(int count : counts) {
                gammaRateBinary = gammaRateBinary + ((count*2 > reportCount) ? "1" : "0");
            }
            int gammaRate = Integer.parseInt(gammaRateBinary, 2);
            return gammaRate;
        }
        private int getEpsilonRate() {
            String epsilonRateBinary = "";
            for(int count : counts) {
                epsilonRateBinary = epsilonRateBinary + ((count*2 <= reportCount) ? "1" : "0");
            }
            int epsilonRate = Integer.parseInt(epsilonRateBinary, 2);
            return epsilonRate;
        }        

        public int calculate() {
            return getGammaRate() * getEpsilonRate();
        }
    }

    public int run(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream(filename)));
        DiagnosticReport report = new DiagnosticReport();
        String line;
        while ((line = reader.readLine()) != null) {
            report.apply(line);
        }
        return report.calculate();
    }

}
