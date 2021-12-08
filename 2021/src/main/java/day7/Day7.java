package day7;

import utils.InputReader;

import java.util.List;
import java.util.TreeMap;
import java.util.function.IntFunction;

public class Day7 {
    static TreeMap<Integer, Integer> crabs = new TreeMap<>();

    public long lowestFuel() {
        List<Integer> crabPositions = new InputReader().inputIntsToArray("/day7.txt");
        long[] sortedCrabPositions = crabPositions.stream().sorted().mapToLong(d -> d).toArray();
        long median = sortedCrabPositions[sortedCrabPositions.length / 2];

        return crabPositions.stream().map(crabPosition -> Math.abs(median - crabPosition)).mapToLong(l -> l).sum();
    }

    public int lowestFuelIncCosts() {
        List<Integer> crabPositions = new InputReader().inputIntsToArray("/day7.txt");

        crabPositions.stream().mapToInt(i -> i).forEach(i -> crabs.put(i, crabs.getOrDefault(i, 0) + 1));
        int min = crabs.firstKey();
        int max = crabs.lastKey();

        return search(min, max, Day7::calculateIncFuel);
    }

    private static int search(int min, int max, IntFunction<Integer> fuelCalculator) {
        int mid, midM1, midP1, a, b, c;

        while ((max - min) > 0) {
            mid = min + (max - min) / 2;
            midM1 = mid - 1;
            midP1 = mid + 1;
            a = fuelCalculator.apply(midM1);
            b = fuelCalculator.apply(mid);
            c = fuelCalculator.apply(midP1);

            if (a < b) {
                max = mid;
            } else if (c < b) {
                min = mid;
            } else return b;
        }
        return fuelCalculator.apply(min);
    }

    private static int calculateIncFuel(int location) {
        return crabs.entrySet().stream().mapToInt(i -> fuelCalcHelper(location, i.getKey()) * i.getValue()).sum();
    }

    private static int fuelCalcHelper(int a, int b) {
        int n = Math.abs(a - b);
        return (n * (n + 1)) / 2;
    }
}
