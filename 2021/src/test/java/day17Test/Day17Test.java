package day17Test;

import day17.Day17;
import org.junit.Assert;
import org.junit.Test;

public class Day17Test {
    private final Day17 day17 = new Day17();

    @Test
    public void testPart1() {
        int result = day17.highestY();

        Assert.assertEquals(6441, result);
    }

    @Test
    public void testPart2() {
        int result = day17.numVelocitiesWithinTarget();

        Assert.assertEquals(3186, result);
    }
}
