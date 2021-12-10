package day5Test;

import day5.Day5;
import org.junit.Assert;
import org.junit.Test;

public class Day5Test {
    @Test
    public void testPart1() {
        int result = new Day5().dangerZone();

        Assert.assertEquals(7318, result);
    }

    @Test
    public void testPart2() {
        int result = new Day5().dangerZoneDiagonals();

        Assert.assertEquals(19939, result);
    }
}
