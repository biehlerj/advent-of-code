package day2;

import utils.InputReader;

import java.util.List;

public class Day2 {
    public int subMovement() {
        int depth = 0;
        int horizontal = 0;
        List<String> movements = new InputReader().inputStrToArray("/day2.txt");

        for (String movement : movements) {
            String[] splitMovement = movement.trim().split("\\s+");
            switch (splitMovement[0]) {
                case "up":
                    depth -= Integer.parseInt(splitMovement[1]);
                    break;
                case "down":
                    depth += Integer.parseInt(splitMovement[1]);
                    break;
                default:
                    horizontal += Integer.parseInt(splitMovement[1]);
            }
        }

        return depth * horizontal;
    }

    public int subMovementPlusAim() {
        int depth = 0;
        int horizontal = 0;
        int aim = 0;
        List<String> movements = new InputReader().inputStrToArray("/day2.txt");

        for (String movement : movements) {
            String[] splitMovement = movement.trim().split("\\s+");
            switch (splitMovement[0]) {
                case "up":
                    aim -= Integer.parseInt(splitMovement[1]);
                    break;
                case "down":
                    aim += Integer.parseInt(splitMovement[1]);
                    break;
                default:
                    horizontal += Integer.parseInt(splitMovement[1]);
                    depth += aim * Integer.parseInt(splitMovement[1]);
            }
        }

        return depth * horizontal;
    }
}
