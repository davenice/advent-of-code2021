package com.niced;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Day1bTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testCode() throws IOException {
        Day1b day1 = new Day1b();
        assertTrue(5 == day1.method("testinput1.txt"));
    }

    @Test
    public void getAnswer() throws IOException {
        Day1b day1 = new Day1b();
        System.out.println(day1.method("input1.txt"));
    }
}
