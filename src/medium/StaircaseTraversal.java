package medium;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StaircaseTraversal {

    public static void main(String[] args) {

        StaircaseTraversal staircaseTraversal = new StaircaseTraversal();

        int result = staircaseTraversal.staircaseTraversal(4, 2);
        System.out.println(result);

    }

    // O(k*n) time | O(n) space
    public int staircaseTraversal(int height, int maxSteps) {
        // Write your code here.

        return numberOfWaysToTop(height, maxSteps);
    }

    private int numberOfWaysToTop(int height, int maxSteps) {
        if (height <= 1) {
            return 1;
        }
        int numberOfWays = 0;
        for (int step = 1; step < Math.min(maxSteps, height) + 1; step++) {
            numberOfWays += numberOfWaysToTop(height - step, maxSteps);
        }
        return numberOfWays;
    }

    // O(n*k) time | O(n) space
    public int staircaseTraversal2(int height, int maxSteps) {
        // Write your code here.
        Map<Integer, Integer> memoize = new HashMap<>();
        return numberOfWaysToTop2(height, maxSteps, memoize);
    }

    private int numberOfWaysToTop2(int height, int maxSteps, Map<Integer, Integer> memoize) {
        if (memoize.containsKey(height)) {
            return memoize.get(height);
        }
        if (height <= 1) {
            return 1;
        }
        int numberOfWays = 0;
        for (int step = 1; step < Math.min(maxSteps, height) + 1; step++) {
            numberOfWays += numberOfWaysToTop2(height - step, maxSteps, memoize);
        }
        memoize.put(height, numberOfWays);
        return numberOfWays;
    }

    // O(n*k) time | O(n) space
    public int staircaseTraversal3(int height, int maxSteps) {
        // Write your code here.
        int[] waysToTop = new int[height + 1];
        waysToTop[0] = 1;
        waysToTop[1] = 1;
        for (int currentHeight = 2; currentHeight < height + 1; currentHeight++) {
            int step = 1;
            while (step <= maxSteps && step <= currentHeight) {
                waysToTop[currentHeight] = waysToTop[currentHeight] + waysToTop[currentHeight - step];
                step++;
            }
        }
        return waysToTop[height];
    }

    // O(n) time | O(n) space (sliding window)
    public int staircaseTraversal4(int height, int maxSteps) {
        int currentNumberOfWays = 0;
        List<Integer> waysToTop = new ArrayList<>();
        waysToTop.add(1);

        for (int currentHeight = 1; currentHeight < height + 1; currentHeight++) {
            int startOfWindow = currentHeight - maxSteps - 1;
            int endOfWindow = currentHeight - 1;
            if (startOfWindow >= 0) {
                currentNumberOfWays -= waysToTop.get(startOfWindow);
            }

            currentNumberOfWays += waysToTop.get(endOfWindow);
            waysToTop.add(currentNumberOfWays);
        }

        return waysToTop.get(height);
    }
}
