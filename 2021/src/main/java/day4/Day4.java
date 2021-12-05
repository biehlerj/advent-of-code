package day4;

import utils.InputReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Day4 {
    private final String path = new InputReader().path;

    public int bingoScore() throws IOException {
        BufferedReader boardReader = new BufferedReader(new FileReader(path + "/day4.txt"));
        int[] input = Arrays.stream(boardReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Board> boards = Board.createBoards(boardReader);

        for (int i = 0; i < input.length; i++) {
            int finalIndex = i;
            Optional<Integer> win = boards.stream().map(b -> b.markNumber(input[finalIndex])).filter(num -> num > 0).findAny();

            if (win.isPresent()) return win.get();
        }

        return -5;
    }

    public int squidGame() throws IOException {
        BufferedReader boardReader = new BufferedReader(new FileReader(path + "/day4.txt"));
        int[] inputs = Arrays.stream(boardReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Board> boards = Board.createBoards(boardReader);

        for (int input : inputs) {
            for (int j = 0, boardSize = boards.size(); j < boardSize; j++, boardSize = boards.size()) {
                int lastWinSum = boards.get(j).markNumber(input);

                if (lastWinSum > 0 && boards.size() == 1) return lastWinSum;
                else if (lastWinSum > 0) {
                    boards.remove(j);
                    j--;
                }
            }
        }
        return -5;
    }
}

