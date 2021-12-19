package day15;

import utils.InputReader;

public class Day15 {
    int[][] riskMap = new InputReader().inputTo2DArr("/day15.txt");

    public int lowestRisk() {
        return evaluateRisk(riskMap);
    }

    public int topLeftBottomRightLowestRisk() {
        int[][] biggerMap = expandMap(riskMap);
        return evaluateRisk(biggerMap);
    }

    private int evaluateRisk(int[][] riskMap) {
        int[][] riskSums = new int[riskMap.length][riskMap[0].length];

        for (int i = 0; i < riskSums.length; i++)
            for (int j = 0; j< riskSums[0].length; j++)
                riskSums[i][j] = 1_000_000;
        riskSums[riskSums.length - 1][riskSums[0].length - 1] = 0;
        boolean changeMade = true;

        while (changeMade) {
            changeMade = false;

            for (int i = riskSums.length - 1; i >= 0; i--) {
                for (int j = riskSums[0].length - 1; j >= 0; j--) {
                    int min = Integer.MAX_VALUE;

                    if (i - 1 >= 0)
                        min = Math.min(min, riskMap[i - 1][j] + riskSums[i - 1][j]);
                    if (i + 1 < riskSums.length)
                        min = Math.min(min, riskMap[i + 1][j] + riskSums[i + 1][j]);
                    if (j - 1 >= 0)
                        min = Math.min(min, riskMap[i][j - 1] + riskSums[i][j - 1]);
                    if (j + 1 < riskSums[0].length)
                        min = Math.min(min, riskMap[i][j + 1] + riskSums[i][j + 1]);

                    int oldRisk = riskSums[i][j];
                    riskSums[i][j] = Math.min(riskSums[i][j], min);

                    if (riskSums[i][j] != oldRisk)
                        changeMade = true;
                }
            }
        }
        return riskSums[0][0];
    }

    private int[][] expandMap(int[][] map) {
        int[][] newMap = new int[5 * map.length][5 * map[0].length];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                int val = map[i][j];

                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        int newNum = val + k + l;

                        if (newNum > 9) newNum -= 9;
                        newMap[i + k * map.length][j + l * map[0].length] = newNum;
                    }
                }
            }
        }
        return newMap;
    }
}
