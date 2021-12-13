package com.niced;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.niced.Day3b.DiagnosticReport;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Day3bTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testCode() throws IOException {
        Day3b day = new Day3b();
        assertTrue(230 == day.run("testinput3.txt"));
    }

    @Test
    public void testGetCommonValueInDiagnostics() {
        Day3b day = new Day3b();
        DiagnosticReport report = day.new DiagnosticReport();
        report.addDiagnostic("01110");
        report.addDiagnostic("11110");
        report.addDiagnostic("10100");
        report.addDiagnostic("10100");

        assertEquals('1', report.getCommonValueInDiagnostics(0, true));
        assertEquals('0', report.getCommonValueInDiagnostics(0, false));
        assertEquals('1', report.getCommonValueInDiagnostics(1, true));
        assertEquals('0', report.getCommonValueInDiagnostics(1, false));
    }

    @Test
    public void testDiagnosticReportFilter() {
        Day3b day = new Day3b();
        DiagnosticReport report = day.new DiagnosticReport();
        List<String> diagnostics = Arrays.asList("1111","0111","1011","1001");
        List<String> filtered = report.filter(diagnostics, 0, '1');
        assertTrue(filtered.size() == 3);
        filtered = report.filter(diagnostics, 0, '0');
        assertTrue(filtered.size() == 1);
        filtered = report.filter(diagnostics, 2, '1');
        assertTrue(filtered.size() == 3);
    }

    @Test
    public void testGetOxygenGeneratorRating() {
        Day3b day = new Day3b();
        DiagnosticReport report = day.new DiagnosticReport();
        report.addDiagnostic("1000");
        report.addDiagnostic("0111");
        report.addDiagnostic("0011");
        report.addDiagnostic("0001");
        assertEquals(3, report.getOxygenGeneratorRating());
    }

    @Test
    public void getAnswer() throws IOException {
        Day3b day = new Day3b();
        System.out.println(day.run("input3.txt"));
    }
}
