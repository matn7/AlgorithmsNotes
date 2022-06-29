package medium;

import java.util.HashMap;
import java.util.Map;

public class StaircaseTraversalREPEAT {

    public static void main(String[] args) {
        int height = 4;
        int maxSteps = 2;

        StaircaseTraversalREPEAT staircaseTraversalREPEAT = new StaircaseTraversalREPEAT();
        int result = staircaseTraversalREPEAT.staircaseTraversal(height, maxSteps);

        System.out.println(result);
    }

      // first
    // OK - repeated 15/02/2022
      //O(k^n) time | O(n) space
//    public int staircaseTraversal(int height, int maxSteps) {
//        return numberOfWaysToTop(height, maxSteps);
//    }
//
//    private int numberOfWaysToTop(int height, int maxSteps) {
//        if (height <= 1) {
//            return 1;
//        }
//
//        int numberOfWays = 0;
//        for (int step = 1; step < Math.min(maxSteps, height) + 1; step++) {
//            numberOfWays += numberOfWaysToTop(height - step, maxSteps);
//        }
//        return numberOfWays;
//    }

//    // second - first solution with memoization
//    // O(k*n) time | O(n) time
//    public int staircaseTraversal(int height, int maxSteps) {
//        Map<Integer, Integer> memoize = new HashMap<>();
//        memoize.put(0, 1);
//        memoize.put(1, 1);
//        return numberOfWaysToTop(height, maxSteps, memoize);
//    }
//
//    // rec(1, 2) - (4) step = 3 => 1
//    // rec(2, 2) - (4) step = 2 => 2
//    // rec(0, 2) - (3) step = 3 => 1
//    // rec(1, 2) - (3) step = 2 => 1
//    // rec(0, 2) - (2) step = 2 => 1
//    // rec(1, 2) - (2) step = 1 => 1
//    // rec(2, 2) - (3) step = 1 => 2
//    // rec(3, 2) - (4) step = 1 => 3
//    // rec(4, 2) -> 3 + 2 = 5
//    private int numberOfWaysToTop(int height, int maxSteps, Map<Integer, Integer> memoize) {
//        if (memoize.containsKey(height)) {
//            return memoize.get(height);
//        }
//        // {0 : 1, 1 : 1, 2 : 2, 3 : 3, 4 : 5}
//        int numberOfWays = 0;
//        for (int step = 1; step < Math.min(maxSteps, height) + 1; step++) {
//            numberOfWays += numberOfWaysToTop(height - step, maxSteps, memoize);
//        }
//        memoize.put(height, numberOfWays);
//        return numberOfWays;
//    }

//    // rec(4, 2)
    // O(n*k) time | O(n) space
    public int staircaseTraversal(int height, int maxSteps) {
        int[] waysToTop = new int[height + 1];
        waysToTop[0] = 1;
        waysToTop[1] = 1;
        // [1, 1, 2, 3, 5]
        //              c
        // step = 2
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
//    public int staircaseTraversal(int height, int maxSteps) {
//        int currentNumberOfWays = 0;
//        int[] waysToTop = new int[height + 1];
//        waysToTop[0] = 1;
//        int counter = 1; // 4
//        // -2 -1  0  1  2  3  4
//        //       [1, 1, 2, 3, 5]
//        //                    c
//        //           s     e
//        for (int currentHeight = 1; currentHeight < height + 1; currentHeight++) {
//            int startOfWindow = currentHeight - maxSteps - 1; // 3 - 2 - 1 = 0
//            int endOfWindow = currentHeight - 1;
//            if (startOfWindow >= 0) {
//                currentNumberOfWays -= waysToTop[startOfWindow]; // 2
//            }
//
//            currentNumberOfWays += waysToTop[endOfWindow]; // 2 + 3 = 5
//            waysToTop[counter] = currentNumberOfWays;
//            counter++;
//            System.out.println(currentNumberOfWays);
//        }
//
//        return waysToTop[height];
//    }

}
