package com.niced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Day3b {

    
    class DiagnosticReport {
        List<String> diagnostics = new ArrayList<>();
        int reportCount = 0;
        int[] counts = null;

        public void addDiagnostic(String diag) {
            diagnostics.add(diag);
        }

        public List<String> filter(List<String> diagnostics, int bit, char requiredBitValue) {
            List<String> filtered = new ArrayList<>();
            // for each of the diagnostic strings
            for (String string : diagnostics) {
                // check if this diagnostic matches
                if (string.charAt(bit) == requiredBitValue) {
                    filtered.add(string);
                }
            }
            return filtered;
        }

        char getCommonValueInDiagnostics(int bit, boolean mostCommon) {
            return getCommonValueInDiagnostics(this.diagnostics, bit, mostCommon);
        }

        char getCommonValueInDiagnostics(List<String> diagnostics, int bit, boolean mostCommon) {
            int countSetBit = 0;
            for (String diag : diagnostics) {
                if(diag.charAt(bit) == '1') {
                    countSetBit++;
                }
            }
            char requiredChar;
            if (mostCommon) {
                requiredChar = (countSetBit * 2 >= diagnostics.size()) ? '1' : '0';
            } else {
                requiredChar = (countSetBit * 2 < diagnostics.size()) ? '1' : '0';
            }
            return requiredChar;
        }
        
        int getOxygenGeneratorRating() {
            List<String> filteredDiagnostics = new ArrayList<>(diagnostics);
            for (int bit=0 ; bit < filteredDiagnostics.get(0).length(); bit++) {
                char requiredBitValue = getCommonValueInDiagnostics(filteredDiagnostics, bit, true);
                filteredDiagnostics = filter(filteredDiagnostics, bit, requiredBitValue);
                if (filteredDiagnostics.size() == 1) break;
            }
            int oxygenGeneratorRating = Integer.parseInt(filteredDiagnostics.get(0), 2);
            return oxygenGeneratorRating;
        }
        int getCO2ScrubberRating() {
            List<String> filteredDiagnostics = new ArrayList<>(diagnostics);
            for (int bit=0 ; bit < filteredDiagnostics.get(0).length(); bit++) {
                char requiredBitValue = getCommonValueInDiagnostics(filteredDiagnostics, bit, false);
                filteredDiagnostics = filter(filteredDiagnostics, bit, requiredBitValue);
                if (filteredDiagnostics.size() == 1) break;
            }
            int oxygenGeneratorRating = Integer.parseInt(filteredDiagnostics.get(0), 2);
            return oxygenGeneratorRating;
        }

        public int calculate() {
            return getOxygenGeneratorRating() * getCO2ScrubberRating();
        }
    }

    public int run(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream(filename)));
        DiagnosticReport report = new DiagnosticReport();
        String line;
        while ((line = reader.readLine()) != null) {
            report.addDiagnostic(line);
        }

        return report.calculate();
    }

}
