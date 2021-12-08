package day7Test;

import day7.Day7;
import org.junit.Assert;
import org.junit.Test;

public class Day7Test {
    @Test
    public void testPart1() {
        long result = new Day7().lowestFuel();

        Assert.assertEquals( 341558, result);
    }

    @Test
    public void testPart2() {
        int result = new Day7().lowestFuelIncCosts();

        Assert.assertEquals(93214037, result);
    }
}
