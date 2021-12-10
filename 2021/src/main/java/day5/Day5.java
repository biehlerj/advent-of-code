package day5;

import utils.InputReader;

import java.util.List;
import java.util.regex.Pattern;

public class Day5 {
    private static final Pattern lineSep = Pattern.compile(",| -> ");
    private static final String path = "/day5.txt";

    public int dangerZone() {
        int[][] vents = new int[1000][1000];
        int x1, x2, y1, y2;
        List<String> inputs = new InputReader().inputToList(path);

        for (String input : inputs) {
            String[] xy1 = input.substring(0, input.indexOf(" ")).split(",");
            String[] xy2 = input.substring(input.lastIndexOf(" ") + 1).split(",");
            x1 = Integer.parseInt(xy1[0]);
            x2 = Integer.parseInt(xy2[0]);
            y1 = Integer.parseInt(xy1[1]);
            y2 = Integer.parseInt(xy2[1]);

            if (x1 == x2) {
                int lowY = Math.min(y1, y2);
                int highY = Math.max(y1, y2);

                for (int y = lowY; y <= highY; y++) vents[x1][y]++;
            } else if (y1 == y2) {
                int lowX = Math.min(x1, x2);
                int highX = Math.max(x1, x2);

                for (int x = lowX; x <= highX; x++) vents[x][y1]++;
            }
        }
        int count = 0;

        for (int[] vent : vents) {
            for (int j = 0; j < vents[0].length; j++) {
                if (vent[j] >= 2) count++;
            }
        }

        return count;
    }

    public int dangerZoneDiagonals() {
        int [][] vents = new int[1000][1000];
        int x1, x2, y1, y2;
        List<String> inputs = new InputReader().inputToList(path);

        for (String input : inputs) {
            String[] xy1 = input.substring(0, input.indexOf(" ")).split(",");
            String[] xy2 = input.substring(input.lastIndexOf(" ") + 1).split(",");
            x1 = Integer.parseInt(xy1[0]);
            x2 = Integer.parseInt(xy2[0]);
            y1 = Integer.parseInt(xy1[1]);
            y2 = Integer.parseInt(xy2[1]);

            if (x1 == x2) {
                int lowY = Math.min(y1, y2);
                int highY = Math.max(y1, y2);

                for (int y = lowY; y <= highY; y++) vents[y][x1]++;
            } else if (y1 == y2) {
                int lowX = Math.min(x1, x2);
                int highX = Math.max(x1, x2);

                for (int x = lowX; x <= highX; x++) vents[y1][x]++;
            } else {
                int slope = (y2 - y1) / (x2 - x1);

                if (slope == 1) {
                    if (x1 < x2) {
                        int y = y1;

                        for (int x = x1; x <= x2; x++) {
                            vents[y][x]++;
                            y++;
                        }
                    } else if (x1 > x2) {
                        int y = y2;

                        for (int x = x2; x <= x1; x++){
                            vents[y][x]++;
                            y++;
                        }
                    }
                } else if (slope == -1) {
                    if (x1 < x2) {
                        int y = y1;

                        for (int x = x1; x <= x2; x++) {
                            vents[y][x]++;
                            y--;
                        }
                    } else if (x1 > x2) {
                        int y = y2;

                        for (int x = x2; x <= x1; x++) {
                            vents[y][x]++;
                            y--;
                        }
                    }
                }
            }
        }
        int count = 0;

        for (int[] vent : vents) {
            for (int j : vent) {
                if (j >= 2) count++;
            }
        }
        return count;
    }
}
