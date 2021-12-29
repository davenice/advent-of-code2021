package com.niced;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Day7bTest 
{

    @Test
    public void testParse() throws IOException {
        Day7b day = new Day7b();
        day.parseFile("testinput7.txt");
    }

    @Test
    public void testCalculateFuelCost() throws IOException {
        Day7b day = new Day7b();
        assertEquals(14, day.calculateFuelCostToAlignAtPosition(new int[] {0, 1, 2, 3, 4, 5}, 2));
    }

    @Test
    public void testCode() throws IOException {
        Day7b day = new Day7b();
        assertEquals(168, day.run("testinput7.txt"));
    }

    @Test
    public void getAnswer() throws IOException {
        Day7b day = new Day7b();
        System.out.println(day.run("input7.txt"));
    }
}
