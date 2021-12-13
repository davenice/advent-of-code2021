package com.niced;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Day5bTest 
{

    @Test
    public void testParse() throws IOException {
        Day5b day = new Day5b();
        day.parseFile("testinput5.txt");
    }

    @Test
    public void testCode() throws IOException {
        Day5b day = new Day5b();
        assertTrue(12 == day.run("testinput5.txt"));
    }

    @Test
    public void getAnswer() throws IOException {
        Day5b day = new Day5b();
        System.out.println(day.run("input5.txt"));
    }
}
