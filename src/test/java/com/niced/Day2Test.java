package com.niced;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Day2Test 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testCode() throws IOException {
        Day2 day = new Day2();
        assertTrue(150 == day.run("testinput2.txt"));
    }

    @Test
    public void getAnswer() throws IOException {
        Day2 day = new Day2();
        System.out.println(day.run("input2.txt"));
    }
}
