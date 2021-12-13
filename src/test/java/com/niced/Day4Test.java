package com.niced;

import static com.niced.Day4.BingoGrid.CALLED;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Day4Test 
{

    @Test
    public void testParse() throws IOException {
        Day4 day = new Day4();
        day.parseFile("testinput4.txt");
        assertEquals(27, day.bingoCalls.length);
        assertEquals(3, day.bingoGrids.size());
        assertEquals(5, day.bingoGrids.get(0).size);
        assertEquals(25, day.bingoGrids.get(0).numbers.size());
    }

    @Test
    public void testCall() throws IOException {
        Day4 day = new Day4();
        day.parseFile("testinput4.txt");
        day.call(22);
        assertEquals(Integer.valueOf(CALLED), day.bingoGrids.get(0).numbers.get(0));
        assertEquals(Integer.valueOf(CALLED), day.bingoGrids.get(1).numbers.get(4));
        assertEquals(Integer.valueOf(CALLED), day.bingoGrids.get(2).numbers.get(15));
    }

    @Test
    public void testIsWinnerOnRow() throws IOException {
        Day4 day = new Day4();
        day.parseFile("testinput4.txt");
        Day4.BingoGrid grid1 = day.bingoGrids.get(0);
        assertFalse(grid1.isWinner());
        day.call(22);
        assertFalse(grid1.isWinner());
        day.call(13);
        day.call(17);
        assertFalse(grid1.isWinner());
        day.call(11);
        day.call(0);
        assertTrue(grid1.isWinner());
    }        

    @Test
    public void testIsWinnerOnCol() throws IOException {
        Day4 day = new Day4();
        day.parseFile("testinput4.txt");
        Day4.BingoGrid grid1 = day.bingoGrids.get(0);
        assertFalse(grid1.isWinner());
        day.call(17);
        assertFalse(grid1.isWinner());
        day.call(23);
        day.call(14);
        day.call(3);
        assertFalse(grid1.isWinner());
        day.call(20);
        assertTrue(grid1.isWinner());
    }        

    @Test
    public void testCode() throws IOException {
        Day4 day = new Day4();
        assertTrue(4512 == day.run("testinput4.txt"));
    }

    @Test
    public void getAnswer() throws IOException {
        Day4 day = new Day4();
        System.out.println(day.run("input4.txt"));
    }
}
