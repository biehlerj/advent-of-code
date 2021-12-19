package utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputReader {
    public String path = new File("src/main/resources/inputs/").getAbsolutePath();

    public List<String> inputToList(String filename) {
        try {
            return Files.lines(Paths.get(path + filename)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Integer> inputNumsToArray(String filename) {
        ArrayList<Integer> intArray = new ArrayList<>();
        List<String> lines = inputToList(filename);

        for (String line : lines) {
            intArray.add(Integer.parseInt(line));
        }

        return intArray;
    }

    public List<Integer> inputIntsToArray(String filename) {
        ArrayList<Integer> intArray = new ArrayList<>();

        try {
            BufferedReader inputReader = new BufferedReader(new FileReader(path + filename));
            String line = inputReader.readLine();
            String[] intsAsStr = line.split(",");

            for (String num : intsAsStr) {
                intArray.add(Integer.parseInt(num));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return intArray;
    }

    public int[][] inputToDoubleArray(String filename, int size1, int size2) {
        int[][] input2DArr = new int[size1][size2];

        try {
            Scanner inputScanner = new Scanner(new File(path + filename));
            int i = 0;

            while (inputScanner.hasNext()) {
                String line = inputScanner.nextLine();
                for (int j = 0; j < line.length(); j++) {
                    input2DArr[i][j] = Integer.parseInt(line.substring(j, j + 1));
                }
                i++;
            }
            inputScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return input2DArr;
    }

    public int[][] inputTo2DArr(String filename) {
        int[][] input2DArr;

        try {
            Scanner inputReader = new Scanner(new File(path + filename));
            List<String> input = new ArrayList<>();

            while (inputReader.hasNext()) input.add(inputReader.nextLine());
            inputReader.close();
            input2DArr = new int[input.size()][input.get(0).length()];

            for (int i = 0; i < input2DArr.length; i++)
                for (int j = 0; j < input2DArr[0].length; j++)
                    input2DArr[i][j] = Integer.parseInt(input.get(i).substring(j, j + 1));
            return input2DArr;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
