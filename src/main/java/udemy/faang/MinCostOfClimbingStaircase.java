package udemy.faang;

import java.util.HashMap;
import java.util.Map;

public class MinCostOfClimbingStaircase {

    public static void main(String[] args) {
        int[] cost = {20, 15, 30, 5};
        MinCostOfClimbingStaircase minCost = new MinCostOfClimbingStaircase();
        int result = minCost.minCostOfClimbingStaircase(cost);
        System.out.println(result);
        int result2 = minCost.minCostOfClimbingStaircaseMemo(cost);
        System.out.println(result2);
        int result3 = minCost.minCostOfClimbingStaircaseIter(cost);
        System.out.println(result3);
        int result4 = minCost.minCostOfClimbingStaircaseOptimal(cost);
        System.out.println(result4);
    }

    // O(2^n) time | O(n) space
    public int minCostOfClimbingStaircase(int[] cost) {
        int n = cost.length;
        return Math.min(minCost(n - 1, cost), minCost(n - 2, cost));
    }

    private int minCost(int i, int[] cost) {
        if (i < 0) {
            return 0;
        }
        if (i == 0 || i == 1) {
            return cost[i];
        }
        return cost[i] + Math.min(minCost(i - 1, cost), minCost(i - 2, cost));
    }

    // O(n) time | O(n) space
    public int minCostOfClimbingStaircaseMemo(int[] cost) {
        Map<Integer, Integer> memoization = new HashMap<>();
        int n = cost.length;
        return Math.min(minCostMemo(n - 1, cost, memoization), minCostMemo(n - 2, cost, memoization));
    }

    private int minCostMemo(int i, int[] cost, Map<Integer, Integer> memoization) {
        if (i < 0) {
            return 0;
        }
        if (i == 0 || i == 1) {
            return cost[i];
        }
        if (memoization.containsKey(i)) {
            return memoization.get(i);
        }
        memoization.put(i, cost[i] + Math.min(minCostMemo(i - 1, cost, memoization),
                minCostMemo(i - 2, cost, memoization)));
        return memoization.get(i);
    }

    // O(n) time | O(n) space
    public int minCostOfClimbingStaircaseIter(int[] cost) {
        Map<Integer, Integer> dp = new HashMap<>();
        int n = cost.length;
        for (int i = 0; i < n; i++) {
            if (i < 2) {
                dp.put(i, cost[i]);
            } else {
                dp.put(i, cost[i] + Math.min(dp.get(i - 1), dp.get(i - 2)));
            }
        }
        return Math.min(dp.get(n - 1), dp.get(n - 2));
    }

    // O(n) time | O(1) space
    public int minCostOfClimbingStaircaseOptimal(int[] cost) {
        int n = cost.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return cost[0];
        }
        int dpOne = cost[0];
        int dpTwo = cost[1];
        for (int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(dpOne, dpTwo);
            dpOne = dpTwo;
            dpTwo = current;
        }
        return Math.min(dpOne, dpTwo);
    }

}
