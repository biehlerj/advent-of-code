package day1Test;

import day1.Day1;
import org.junit.Assert;
import org.junit.Test;

public class Day1Test {
    @Test
    public void testPart1() {
        int result = new Day1().depthIncreases();

        Assert.assertEquals(1752, result);
    }

    @Test
    public void testPart2() {
        int result = new Day1().depthWindowIncreases();

        Assert.assertEquals(1781, result);
    }
}
