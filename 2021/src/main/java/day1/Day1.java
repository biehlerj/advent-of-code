package day1;

import utils.InputReader;

import java.util.List;

public class Day1 {
    public List<Integer> depths = new InputReader().inputNumsToArray("/day1.txt");

    public int depthIncreases() {
        int depthChanges = 0;

        for (int i = 1; i < depths.size(); i++) {
            int curr = depths.get(i);
            int prev = depths.get(i - 1);

            if (curr > prev) depthChanges++;
        }

        return depthChanges;
    }

    public int depthWindowIncreases() {
        int depthChanges = 0;

        for (int i = 3; i < depths.size(); i++) {
            int curr = depths.get(i) + depths.get(i - 1) + depths.get(i - 2);
            int prev = depths.get(i - 1) + depths.get(i - 2) + depths.get(i - 3);

            if (curr > prev) depthChanges++;
        }

        return depthChanges;
    }
}
