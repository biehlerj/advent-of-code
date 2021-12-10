package day9Test;

import day9.Day9;
import org.junit.Assert;
import org.junit.Test;

public class Day9Test {
    @Test
    public void testPar1() {
        int result = new Day9().riskLevels();

        Assert.assertEquals(564, result);
    }

    @Test
    public void testPart2() {
        int result = new Day9().threeLargestBasins();

        Assert.assertEquals(1038240, result);
    }
}
