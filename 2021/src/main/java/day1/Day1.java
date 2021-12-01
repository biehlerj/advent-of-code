package day1;

import utils.InputReader;

import java.util.List;

public class Day1 {
    public int depthIncreases() {
        List<Integer> depths = new InputReader().inputNumsToArray("/day1.txt");
        int depthChanges = 0;
        int compare = depths.get(0);

        for (int i = 1; i < depths.size(); i++) {
            if (depths.get(i) - compare > 0) {
                depthChanges += 1;
            }
            compare = depths.get(i);
        }

        return depthChanges;
    }
}
