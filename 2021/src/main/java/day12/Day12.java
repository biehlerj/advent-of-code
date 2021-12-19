package day12;

import utils.InputReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day12 {
    private final List<String> cavePaths = new InputReader().inputToList("/day12.txt");

    public int smallCaveVisitOnce() {
        return findPaths(false).size();
    }

    public int totalPaths() {
        return findPaths(true).size();
    }

    private List<String> findPaths(boolean totalAll) {
        List<String> completedPaths = new ArrayList<>();
        Stack<String> currPaths = new Stack<>();
        currPaths.add("start");

        while (currPaths.size() > 0) {
            String path = currPaths.pop();
            String currCave = path.substring(path.lastIndexOf("-") + 1);
            StringBuilder connCave = new StringBuilder();

            for (String cavePath : cavePaths) {
                if (cavePath.contains(currCave))
                    connCave.append(cavePath.replace("-", "").replace(currCave, "")).append(" ");
            }
            String[] accessibleCaves = connCave.toString().trim().split(" ");

            for (String cave : accessibleCaves) {
                if (cave.equals("start")) continue;
                else if (cave.equals("end")) completedPaths.add(path + "-" + cave);
                else if (cave.equals(cave.toLowerCase())) {
                    if (!path.contains(cave)) currPaths.add(path + "-" + cave);
                    else if (totalAll && !path.contains("X:")) currPaths.add("X:" + path + "-" + cave);
                } else currPaths.add(path + "-" + cave);
            }
        }
        return completedPaths;
    }
}
