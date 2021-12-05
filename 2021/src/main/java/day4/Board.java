package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    private static final int DIMENSION = 5;
    private final int[][] boardLines;
    private final boolean[][] marked;
    private int sumOfUnmarked;

    public Board(int[][] boardLines) {
        this.boardLines = boardLines;
        marked = new boolean[DIMENSION][DIMENSION];

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                sumOfUnmarked += boardLines[i][j];
            }
        }
    }

    public int markNumber(int numToMark) {
        boolean exit = false;

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (boardLines[i][j] == numToMark) {
                    exit = true;
                    marked[i][j] = true;
                    sumOfUnmarked -= boardLines[i][j];
                    break;
                }
            }

            if (exit) break;
        }

        if (exit) {
            if (checkWin()) {
                return numToMark * sumOfUnmarked;
            }
        }
        return -1;
    }

    private boolean checkWin() {
        return checkForHorizontal() || checkForVertical();
    }

    private boolean checkForHorizontal() {
        for (int i = 0; i < DIMENSION; i++) {
            int count = 0;

            for (int j = 0; j < DIMENSION; j++) {
                if (marked[i][j]) count++;
                else break;
            }

            if (count == DIMENSION) return true;
        }

        return false;
    }

    private boolean checkForVertical() {
        for (int i = 0; i < DIMENSION; i++) {
            int count = 0;

            for (int j = 0; j < DIMENSION; j++) {
                if (marked[j][i]) count++;
                else break;
            }

            if (count == DIMENSION) return true;
        }

        return false;
    }

    public static ArrayList<Board> createBoards(BufferedReader br) throws IOException {
        String strLine = br.readLine();
        ArrayList<Board> boards = new ArrayList<>();
        int boardIndex = 0;
        int[][] boardLines = new int[0][];

        while ((strLine = br.readLine()) != null) {
            if (strLine.isEmpty()) continue;

            if (boardIndex == 0) boardLines = new int[DIMENSION][DIMENSION];

            boardLines[boardIndex++] = Arrays.stream(strLine.split(" ")).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).toArray();

            if (boardIndex == DIMENSION) {
                boards.add(new Board(boardLines));
                boardIndex = 0;
            }
        }

        return boards;
    }
}
