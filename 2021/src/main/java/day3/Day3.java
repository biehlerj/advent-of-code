package day3;

import utils.InputReader;

import java.util.List;

public class Day3 {
    public int powerConsumption() {
        StringBuilder epsilonStringBuilder = new StringBuilder();
        StringBuilder gammaStringBuilder = new StringBuilder();
        List<String> powerBinary = new InputReader().inputToList("/day3.txt");

        for (int i = 0; i < powerBinary.get(0).length(); i++) {
            int zeroes = 0;
            int ones = 0;
            for (String s : powerBinary) {
                if (s.charAt(i) == '0') zeroes++;
                else ones++;
            }
            gammaStringBuilder.append(ones > zeroes ? "1" : "0");
            epsilonStringBuilder.append(ones < zeroes ? "1" : 0);
        }

        return Integer.parseInt(gammaStringBuilder.toString(), 2) * Integer.parseInt(epsilonStringBuilder.toString(), 2);
    }

    public int lifeSupportRating() {
        List<String> co2 = new InputReader().inputToList("/day3.txt");
        List<String> oxygen = new InputReader().inputToList("/day3.txt");

        int i = 0;
        while (oxygen.size() > 1) {
            int zeroes = 0;
            int ones = 0;
            for (String s : oxygen) {
                if (s.charAt(i) == '0') zeroes++;
                else ones++;
            }
            char max = (ones >= zeroes ? '1' : '0');
            for (int end = oxygen.size() - 1; end >= 0; end--) {
                if (oxygen.get(end).charAt(i) != max) oxygen.remove(end);
            }
            i++;
        }

        i = 0;
        while (co2.size() > 1) {
            int zeroes = 0;
            int ones = 0;
            for (String s : co2) {
                if (s.charAt(i) == '0') zeroes++;
                else ones++;
            }
            char min = (zeroes <= ones ? '0' : '1');
            for (int end = co2.size() - 1; end >= 0; end--) {
                if (co2.get(end).charAt(i) != min) co2.remove(end);
            }
            i++;
        }

        return Integer.parseInt(oxygen.get(0), 2) * Integer.parseInt(co2.get(0), 2);
    }
}
