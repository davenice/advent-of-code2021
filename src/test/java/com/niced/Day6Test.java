package com.niced;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Day6Test 
{

    @Test
    public void testParse() throws IOException {
        Day6 day = new Day6();
        day.parseFile("testinput6.txt");
    }

    @Test
    public void testCode18() throws IOException {
        Day6 day = new Day6();
        assertEquals(26, day.run("testinput6.txt", 18));
    }

    @Test
    public void testCode80() throws IOException {
        Day6 day = new Day6();
        assertEquals(5934, day.run("testinput6.txt", 80));
    }


    @Test
    public void getAnswer() throws IOException {
        Day6 day = new Day6();
        System.out.println(day.run("input6.txt", 80));
    }
}
