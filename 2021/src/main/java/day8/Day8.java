package day8;

import utils.InputReader;

import java.util.List;

public class Day8 {
    List<String> displayStrings = new InputReader().inputToList("/day8.txt");

    public int oneFourSevenEightTotal() {
        int total = 0;

        for (String display : displayStrings) {
            String[] displayStringsWoSep = display.split("\\s\\|\\s");
            String[] displayStringsRight = displayStringsWoSep[1].split(" ");

            for (String s : displayStringsRight) {
                if (s.trim().length() == 2 || s.trim().length() == 3 || s.trim().length() == 4 || s.trim().length() == 7)
                    total++;
            }
        }
        return total;
    }

    public long allOutputs() {
        long sum = 0;

        for (String display : displayStrings) {
            String[] displayStrsWoSep = display.split("\\s\\|\\s");
            String[] displayStrsLeft = displayStrsWoSep[0].split(" ");
            String[] nums = new String[10];

            for (String s : displayStrsLeft) {
                if (s.length() == 2) nums[1] = s;
                else if (s.length() == 4) nums[4] = s;
                else if (s.length() == 3) nums[7] = s;
                else if (s.length() == 7) nums[8] = s;
            }

            String extra4 = nums[4].replaceAll(nums[1].substring(0, 1), "").replaceAll(nums[1].substring(1, 2), "");

            for (String left : displayStrsLeft) {
                boolean checkNums = left.indexOf(nums[1].charAt(0)) != -1 && left.indexOf(nums[1].charAt(1)) != -1;
                boolean checkExtra = left.indexOf(extra4.charAt(0)) != -1 && left.indexOf(extra4.charAt(1)) != -1;
                if (left.length() == 5) {
                    if (checkNums) nums[3] = left;
                    else if (checkExtra) nums[5] = left;
                    else nums[2] = left;
                } else if (left.length() == 6) {
                    if (!(checkNums)) nums[6] = left;
                    else if (checkExtra) nums[9] = left;
                    else nums[0] = left;
                }
            }
            String[] displayStrsRight = displayStrsWoSep[1].split(" ");
            StringBuilder num = new StringBuilder();

            for (String s : displayStrsRight) {
                for (int p = 0; p < nums.length; p++) {
                    if (s.length() == nums[p].length()) {
                        boolean found = true;
                        for (int k = 0; k < s.length(); k++) {
                            if (s.indexOf(nums[p].charAt(k)) == -1) {
                                found = false;
                                break;
                            }
                        }
                        if (found) num.append(p);
                    }
                }
            }
            sum += Integer.parseInt(num.toString());
        }
        return sum;
    }
}
