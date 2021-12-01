package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {
    public String path = new File("src/main/resources/inputs/").getAbsolutePath();

    public List<Integer> inputNumsToArray(String filename) {
        ArrayList<Integer> intArray = new ArrayList<Integer>();

        try {
            BufferedReader inputReader = new BufferedReader(new FileReader(path + filename));

            String line = inputReader.readLine();

            while (line != null) {
                intArray.add(Integer.parseInt(line));
                line = inputReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return intArray;
    }
}
