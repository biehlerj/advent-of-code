package day2Test;

import day2.Day2;
import org.junit.Assert;
import org.junit.Test;

public class Day2Test {
    @Test
    public void testPart1() {
        int result = new Day2().subMovement();

        Assert.assertEquals(2027977, result);
    }

    @Test
    public void testPart2() {
        int result = new Day2().subMovementPlusAim();

        Assert.assertEquals(1903644897, result);
    }
}
