package day6Test;

import day6.Day6;
import org.junit.Assert;
import org.junit.Test;

public class Day6Test {
    @Test
    public void testPart1() {
        long result = new Day6().lanternFishXDays(80);

        Assert.assertEquals(386640, result);
    }

    @Test
    public void testPart2() {
        long result = new Day6().lanternFishXDays(256);

        Assert.assertEquals(1733403626279L, result);
    }
}
