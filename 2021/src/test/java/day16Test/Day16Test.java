package day16Test;

import day16.Day16;
import org.junit.Assert;
import org.junit.Test;

public class Day16Test {
    private final Day16 day16 = new Day16();

    @Test
    public void testPart1() {
        long result = day16.versionNumSum();

        Assert.assertEquals(949, result);
    }

    @Test
    public void testPart2() {
        day16.versionNumSum();
        long result = day16.hexadecimal2Long();

        Assert.assertEquals(1114600142730L, result);
    }
}
