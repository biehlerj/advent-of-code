package day11;

import utils.InputReader;

public class Day11 {
    private final int[][] originalGrid = new InputReader().inputToDoubleArray("/day11.txt", 10, 10);
    private int flashes = 0;

    public int flashesAfter100() {
        int[][] grid = copyOriginalGrid();

        for (int day = 1; day <= 100; day++) {
            updateGrid(grid);
        }
        return flashes;
    }

    public int syncedOctopiFlashes() {
        int[][] grid = copyOriginalGrid();
        int step = 0;

        while (!allZeroes(grid)) {
            updateGrid(grid);
            step++;
        }
        return step;
    }

    private int[][] copyOriginalGrid() {
        int[][] copy = new int[originalGrid.length][originalGrid[0].length];
        for (int r = 0; r < copy.length; r++) {
            System.arraycopy(originalGrid[r], 0, copy[r], 0, copy[0].length);
        }
        return copy;
    }

    private void updateGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j]++;
            }
        }
        checkForTens(grid);
    }

    private void checkForTens(int[][] grid) {
        boolean isFlashing = false;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] >= 10) {
                    grid[i][j] = 0;
                    flashes++;
                    isFlashing = true;
                    increaseNeighbors(grid, i, j);
                }
            }
        }

        if (isFlashing) checkForTens(grid);
    }

    private void increaseNeighbors(int[][] grid, int i, int i1) {
        int[] delta = new int[] { -1, 0, 1 };

        for (int x = 0; x < delta.length; x++) {
            for (int y = 0; y < delta.length; y++) {
                if (x == 1 && y == 1) continue;
                if (isFlashIncrement(grid, i + delta[x], i1 + delta[y])) grid[i + delta[x]][i1 + delta[y]]++;
            }
        }
    }

    private boolean isFlashIncrement(int[][] grid, int i, int j) {
        return (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] != 0);
    }

    private boolean allZeroes(int[][] grid) {
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] != 0) return false;
            }
        }
        return true;
    }
}
