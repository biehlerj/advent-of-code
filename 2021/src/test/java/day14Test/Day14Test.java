package day14Test;

import day14.Day14;
import org.junit.Assert;
import org.junit.Test;

public class Day14Test {
    private final Day14 day14 = new Day14();

    @Test
    public void testPart1() {
        long result = day14.leastMostCommonDiff();

        Assert.assertEquals(2170, result);
    }

    @Test
    public void testPart2() {
        long result = day14.sumLeastMostCommonDiff();
        System.out.println(result);
//        Assert.assertEquals(0L, result);
    }
}
