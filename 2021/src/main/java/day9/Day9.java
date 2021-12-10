package day9;

import utils.InputReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day9 {
    int[][] lavaTubes;
    String filename = "/day9.txt";

    public int riskLevels() {
        int riskLevel = 0;
        buildLavaTubes();

        for (int i = 0; i < lavaTubes.length; i++) {
            for (int j = 0; j < lavaTubes[i].length; j++) {
                if (lavaTubes[i][j] < lowestNeighbor(i, j)) {
                    riskLevel += lavaTubes[i][j] + 1;
                }
            }
        }

        return riskLevel;
    }

    public int threeLargestBasins() {
        List<Integer> sizes = new ArrayList<>();
        buildLavaTubes();

        for (int i = 0; i < lavaTubes.length; i++) {
            for (int j = 0; j < lavaTubes[i].length; j++) {
                if (lavaTubes[i][j] < lowestNeighbor(i, j)) {
                    sizes.add(basinSize(i, j));
                }
            }
        }
        sizes.sort(Collections.reverseOrder());

        return sizes.get(0) * sizes.get(1) * sizes.get(2);
    }

    private int basinSize(int i, int j) {
        if(borders(i, j) == 9) return 0;
        lavaTubes[i][j] = 9;
        return 1 + basinSize(i - 1, j) + basinSize(i + 1, j) + basinSize(i, j - 1) + basinSize(i, j + 1);
    }

    private int lowestNeighbor(int i, int j) {
        int lowest = Integer.MAX_VALUE;
        lowest = Math.min(lowest, borders(i - 1, j));
        lowest = Math.min(lowest, borders(i + 1, j));
        lowest = Math.min(lowest, borders(i, j - 1));
        lowest = Math.min(lowest, borders(i, j + 1));
        return lowest;
    }

    private int borders(int i, int j) {
        return (i < 0 || i >= lavaTubes.length || j < 0 || j >= lavaTubes[i].length) ? 9 : lavaTubes[i][j];
    }

    private void buildLavaTubes() {
        List<String> maps = new InputReader().inputToList(filename);
        lavaTubes = maps.stream().map(line -> line.chars().map(Character::getNumericValue).toArray()).toArray(size -> new int[size][0]);
    }
}
