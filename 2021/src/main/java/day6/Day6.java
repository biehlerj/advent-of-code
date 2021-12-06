package day6;

import utils.InputReader;

import java.util.Arrays;
import java.util.List;

public class Day6 {
    public long lanternFishXDays(int days) {
        List<Integer> lanternFish = new InputReader().inputIntsToArray("/day6.txt");
        long[] fishTimerFrequencies = new long[9];

        for (int ft : lanternFish) {
            fishTimerFrequencies[ft]++;
        }

        for (int day = 0; day < days; day++) {
            long timeouts = fishTimerFrequencies[0];
            System.arraycopy(fishTimerFrequencies, 1, fishTimerFrequencies, 0, 8);
            fishTimerFrequencies[6] += timeouts;
            fishTimerFrequencies[8] = timeouts;
        }
        return Arrays.stream(fishTimerFrequencies).sum();
    }
}
