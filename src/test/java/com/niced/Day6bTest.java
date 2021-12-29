package com.niced;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Day6bTest 
{

    @Test
    public void testParse() throws IOException {
        Day6b day = new Day6b();
        day.parseFile("testinput6.txt");
    }

    @Test
    public void testCode18() throws IOException {
        Day6b day = new Day6b();
        assertEquals(26, day.run("testinput6.txt", 18));
    }

    @Test
    public void testCode80() throws IOException {
        Day6b day = new Day6b();
        assertEquals(5934, day.run("testinput6.txt", 80));
    }

    @Test
    public void testCode256() throws IOException {
        Day6b day = new Day6b();
        assertEquals(26984457539L, day.run("testinput6.txt", 256));
    }

    @Test
    public void getAnswer() throws IOException {
        Day6b day = new Day6b();
        System.out.println(day.run("input6.txt", 256));
    }
}
