package day8Test;

import day8.Day8;
import org.junit.Assert;
import org.junit.Test;

public class Day8Test {
    @Test
    public void testPart1() {
        int result = new Day8().oneFourSevenEightTotal();

        Assert.assertEquals(310, result);
    }

    @Test
    public void testPart2() {
        long result = new Day8().allOutputs();

        Assert.assertEquals(915941, result);
    }
}
