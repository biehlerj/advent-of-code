package day13;

import HelperClasses.Point;
import utils.InputReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day13 {
    private List<Point> points;
    private List<String> folds;

    public Day13() {
        try {
            Scanner inputScanner = new Scanner(new File(new InputReader().path + "/day13.txt"));
            points = new ArrayList<>();
            folds = new ArrayList<>();

            while (inputScanner.hasNext()) {
                String line = inputScanner.nextLine();

                if (line.equals("")) continue;
                if (line.contains(",")) {
                    String[] sp = line.split(",");
                    points.add(new Point(Integer.parseInt(sp[0]), Integer.parseInt(sp[1])));
                } else folds.add(line);
            }
            inputScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int numDotsAfterFold() {
        String fold = folds.get(0);

        if (fold.contains("x=")) foldLeft(fold);
        else foldUp(fold);

        boolean[][] grid = makeGrid();
        return countPointsGrid(grid);
    }

    public void cameraCode() {
        for (int f = 1; f < folds.size(); f++) {
            String fold = folds.get(f);

            if (fold.contains("x=")) foldLeft(fold);
            else foldUp(fold);
        }
        boolean[][] grid = makeGrid();
        printGrid();
    }

    private void foldUp(String fold) {
        int y = Integer.parseInt(fold.substring(fold.indexOf("=") + 1));

        for (Point point : points)
            if (point.getY() > y)
                point.setY(y - (point.getY() - y));
    }

    private void foldLeft(String fold) {
        int x = Integer.parseInt(fold.substring(fold.indexOf("=") + 1));

        for (Point point : points)
            if (point.getX() > x)
                point.setX(x - (point.getX() - x));
    }

    private boolean[][] makeGrid() {
        int maxX = points.stream().max(Comparator.comparingInt(Point::getX)).get().getX();
        int maxY = points.stream().max(Comparator.comparingInt(Point::getY)).get().getY();
        boolean[][] grid = new boolean[maxY + 1][maxX + 1];

        for (Point point : points) {
            int x = point.getX();
            int y = point.getY();
            grid[y][x] = true;
        }
        return grid;
    }

    private int countPointsGrid(boolean[][] grid) {
        int count = 0;

        for (boolean[] booleans : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (booleans[j]) count++;
            }
        }
        return count;
    }

    private void printGrid() {
        int maxX = points.stream().mapToInt(Point::getX).max().orElse(0) + 1;
        int maxY = points.stream().mapToInt(Point::getY).max().orElse(0) + 1;
        char[][] grid = new char[maxY][maxX];

        for (int y = 0; y < maxY; y++) Arrays.fill(grid[y], '.');
        for (Point point : points) grid[point.getY()][point.getX()] = '#';
        for (int y = 0; y < maxY; y++) {
            System.out.println(grid[y]);
            System.out.println('\n');
        }
    }
}
