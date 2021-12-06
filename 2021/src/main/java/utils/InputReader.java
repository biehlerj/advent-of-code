package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {
    public String path = new File("src/main/resources/inputs/").getAbsolutePath();

    public List<Integer> inputNumsToArray(String filename) {
        ArrayList<Integer> intArray = new ArrayList<>();

        try {
            BufferedReader inputReader = new BufferedReader(new FileReader(path + filename));

            String line = inputReader.readLine();

            while (line != null) {
                intArray.add(Integer.parseInt(line));
                line = inputReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return intArray;
    }

    public List<String> inputStrToArray(String filename) {
        ArrayList<String> strArray = new ArrayList<>();

        try {
            BufferedReader inputReader = new BufferedReader(new FileReader(path + filename));

            String line = inputReader.readLine();

            while (line != null) {
                strArray.add(line);
                line = inputReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strArray;
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
