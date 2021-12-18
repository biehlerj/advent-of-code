package day11Test;

import day11.Day11;
import org.junit.Assert;
import org.junit.Test;

public class Day11Test {
    @Test
    public void testPart1() {
        int result = new Day11().flashesAfter100();

        Assert.assertEquals(1613, result);
    }

    @Test
    public void testPart2() {
        int result = new Day11().syncedOctopiFlashes();

        Assert.assertEquals(510, result);
    }
}
