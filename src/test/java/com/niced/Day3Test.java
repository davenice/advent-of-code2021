package com.niced;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Day3Test 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testCode() throws IOException {
        Day3 day = new Day3();
        assertTrue(198 == day.run("testinput3.txt"));
    }

    @Test
    public void getAnswer() throws IOException {
        Day3 day = new Day3();
        System.out.println(day.run("input3.txt"));
    }
}
