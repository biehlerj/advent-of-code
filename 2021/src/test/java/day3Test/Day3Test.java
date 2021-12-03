package day3Test;

import day3.Day3;
import org.junit.Assert;
import org.junit.Test;

public class Day3Test {
    @Test
    public void testPart1() {
        int result = new Day3().powerConsumption();

        Assert.assertEquals(4147524, result);
    }

    @Test
    public void testPart2() {
        int result = new Day3().lifeSupportRating();

        Assert.assertEquals(3570354, result);
    }
}
