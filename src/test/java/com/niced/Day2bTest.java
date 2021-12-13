package com.niced;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Day2bTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testCode() throws IOException {
        Day2b day = new Day2b();
        assertTrue(900 == day.run("testinput2.txt"));
    }

    @Test
    public void getAnswer() throws IOException {
        Day2b day = new Day2b();
        System.out.println(day.run("input2.txt"));
    }
}
