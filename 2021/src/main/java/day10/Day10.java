package day10;

import utils.InputReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Day10 {
    private final List<String> inputs = new InputReader().inputToList("/day10.txt");
    private List<Long> scores;
    private HashMap<Character, Character> openToCloseMap;
    private HashMap<Character, Character> closeToOpenMap;
    private HashMap<Character, Integer> incorrectCloserValues;
    private HashMap<Character, Integer> pointValues;

    private void build() {
        openToCloseMap = new HashMap<>();
        openToCloseMap.put('(', ')');
        openToCloseMap.put('[', ']');
        openToCloseMap.put('{', '}');
        openToCloseMap.put('<', '>');
        closeToOpenMap = new HashMap<>();
        closeToOpenMap.put(')', '(');
        closeToOpenMap.put(']', '[');
        closeToOpenMap.put('}', '{');
        closeToOpenMap.put('>', '<');
        incorrectCloserValues = new HashMap<>();
        incorrectCloserValues.put(')', 3);
        incorrectCloserValues.put(']', 57);
        incorrectCloserValues.put('}', 1197);
        incorrectCloserValues.put('>', 25137);
        pointValues = new HashMap<>();
        pointValues.put(')', 1);
        pointValues.put(']', 2);
        pointValues.put('}', 3);
        pointValues.put('>', 4);

    }

    public long syntaxErrorScore() {
        build();
        scores = new ArrayList<>();
        long syntaxErrors = 0;

        for (String input : inputs) {
            String completionString = getCompletionString(input);

            if (completionString.contains("Invalid")) {
                char invalidChar = completionString.charAt(completionString.length() - 1);
                syntaxErrors += incorrectCloserValues.get(invalidChar);
            } else scores.add(getScore(completionString));
        }
        return syntaxErrors;
    }

    public long middleScore() {
        syntaxErrorScore();
        scores.sort(null);
        return scores.get(scores.size() / 2);
    }

    private String getCompletionString(String input) {
        StringBuilder compStr = new StringBuilder();
        Stack<Character> openers = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{' || ch == '<') openers.add(ch);
            else if (!(openers.pop() == closeToOpenMap.get(ch))) return "Invalid " + ch;
        }

        while (openers.size() > 0) compStr.append(openToCloseMap.get(openers.pop()));
        return compStr.toString();
    }

    private long getScore(String closers) {
        long sum = 0;

        for (int i = 0; i < closers.length(); i++) {
            sum *= 5;
            sum += pointValues.get(closers.charAt(i));
        }
        return sum;
    }
}
