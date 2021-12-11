package day10Test;

import day10.Day10;
import org.junit.Assert;
import org.junit.Test;

public class Day10Test {
    @Test
    public void testPart1() {
        long result = new Day10().syntaxErrorScore();

        Assert.assertEquals(311895, result);
    }

    @Test
    public void testPart2() {
        long result = new Day10().middleScore();

        Assert.assertEquals(2904180541L, result);
    }
}
