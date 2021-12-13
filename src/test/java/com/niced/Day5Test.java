package com.niced;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Day5Test 
{

    @Test
    public void testParse() throws IOException {
        Day5 day = new Day5();
        day.parseFile("testinput5.txt");
    }

    @Test
    public void testCode() throws IOException {
        Day5 day = new Day5();
        assertTrue(5 == day.run("testinput5.txt"));
    }

    @Test
    public void getAnswer() throws IOException {
        Day5 day = new Day5();
        System.out.println(day.run("input5.txt"));
    }
}
