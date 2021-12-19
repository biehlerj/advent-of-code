package day13Test;

import day13.Day13;
import org.junit.Assert;
import org.junit.Test;

public class Day13Test {
    private final Day13 day13 = new Day13();

    @Test
    public void testPart1() {
        int result = day13.numDotsAfterFold();
        day13.cameraCode();
        Assert.assertEquals(592, result);
    }

//    @Test
//    public void testPart2() {
//        String result = day13
//    }
}
