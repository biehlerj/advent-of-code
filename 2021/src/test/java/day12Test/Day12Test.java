package day12Test;

import day12.Day12;
import org.junit.Assert;
import org.junit.Test;

public class Day12Test {
    @Test
    public void testPart1() {
        int result = new Day12().smallCaveVisitOnce();

        Assert.assertEquals(4167, result);
    }

    @Test
    public void testPart2() {
        int result = new Day12().totalPaths();

        Assert.assertEquals(98441, result);
    }
}
