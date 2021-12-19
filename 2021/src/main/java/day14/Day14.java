package day14;

import utils.InputReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day14 {
    private Map<String, String> pairInsertionRules;
    private Map<String, Long> elementPairCounts;
    private String template;

    public Day14() {
        try {
            Scanner inputReader = new Scanner(new File(new InputReader().path + "/day14.txt"));
            List<String> input = new ArrayList<>();

            while (inputReader.hasNext()) input.add(inputReader.nextLine());
            inputReader.close();
            template = input.remove(0);
            input.remove(0);
            elementPairCounts = getElementPairCounts(template);
            pairInsertionRules = makeMap(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Map<String, String> makeMap(List<String> input) {
        Map<String, String> map = new HashMap<>();

        for (String s : input) {
            String[] sp = s.split(" -> ");
            map.put(sp[0], sp[1]);
        }
        return map;
    }

    private Map<String, Long> getElementPairCounts(String template) {
        Map<String, Long> map = new HashMap<>();

        for (int i = 0; i <= template.length() - 2; i++) {
            String dd = template.substring(i, i + 2);
            map.putIfAbsent(dd, 0L);
            map.put(dd, map.get(dd) + 1);
        }
        return map;
    }

    public long leastMostCommonDiff() {
        for (int step = 1; step <= 10; step++)
            elementPairCounts = updateCountsMap();
        return getMaxMinDiff();
    }

    public long sumLeastMostCommonDiff() {
        for (int step = 1; step <= 40; step++)
            elementPairCounts = updateCountsMap();
        return getMaxMinDiff();
    }

    private long getMaxMinDiff() {
        Map<Character, Long> charCounts = new HashMap<>();

        for (Map.Entry<String, Long> entry : elementPairCounts.entrySet()) {
            char element = entry.getKey().charAt(0);
            long count = entry.getValue();
            charCounts.put(element, charCounts.containsKey(element) ? charCounts.get(element) + count : count);
        }
        char lastElement = template.charAt(template.length() - 1);
        charCounts.put(lastElement, charCounts.get(lastElement) + 1);
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for (Map.Entry<Character, Long> entry : charCounts.entrySet()) {
            min = Math.min(min, entry.getValue());
            max = Math.max(max, entry.getValue());
        }
        return (max - min);
    }

    private Map<String, Long> updateCountsMap() {
        Map<String, Long> newMap = new HashMap<>();

        for (Map.Entry<String, Long> entry : elementPairCounts.entrySet()) {
            String a = entry.getKey().substring(0, 1);
            String b = entry.getKey().substring(1, 2);
            String c = pairInsertionRules.get(a + b);
            String ab = a + b;
            String ac = a + c;
            String cb = c + b;
            newMap.merge(ac, elementPairCounts.get(ab), Long::sum);
            newMap.merge(cb, elementPairCounts.get(ab), Long::sum);
        }
        return newMap;
    }
}
