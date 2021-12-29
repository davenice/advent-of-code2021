package com.niced;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Day7Test 
{

    @Test
    public void testParse() throws IOException {
        Day7 day = new Day7();
        day.parseFile("testinput7.txt");
    }

    @Test
    public void testCalculateFuelCost() throws IOException {
        Day7 day = new Day7();
        assertEquals(2+1+1+2+3, day.calculateFuelCostToAlignAtPosition(new int[] {0, 1, 2, 3, 4, 5}, 2));
        assertEquals(2+3+1+18, day.calculateFuelCostToAlignAtPosition(new int[] {0, 5, 2, 1, 2, 2, 20}, 2));
    }

    @Test
    public void testCode() throws IOException {
        Day7 day = new Day7();
        assertEquals(37, day.run("testinput7.txt"));
    }

    @Test
    public void getAnswer() throws IOException {
        Day7 day = new Day7();
        System.out.println(day.run("input7.txt"));
    }
}
