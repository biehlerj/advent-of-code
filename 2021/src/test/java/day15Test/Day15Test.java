package day15Test;

import day15.Day15;
import org.junit.Assert;
import org.junit.Test;

public class Day15Test {
    private final Day15 day15 = new Day15();

    @Test
    public void testPart1() {
        int result = day15.lowestRisk();

        Assert.assertEquals(415, result);
    }

    @Test
    public void testPart2() {
        int result = day15.topLeftBottomRightLowestRisk();

        Assert.assertEquals(2864, result);
    }
}
