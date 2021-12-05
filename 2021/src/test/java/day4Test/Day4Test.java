package day4Test;

import day4.Day4;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day4Test {
    @Test
    public void testPart1() {
        try {
            int result = new Day4().bingoScore();

            Assert.assertEquals(44736, result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPart2() {
        try {
            int result = new Day4().squidGame();

            Assert.assertEquals(1827, result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
