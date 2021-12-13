package com.niced;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Day1Test 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testCode() throws IOException {
        Day1 day1 = new Day1();
        assertTrue(7 == day1.method("testinput1.txt"));
    }

    @Test
    public void getAnswer() throws IOException {
        Day1 day1 = new Day1();
        System.out.println(day1.method("input1.txt"));
    }
}
