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
}
