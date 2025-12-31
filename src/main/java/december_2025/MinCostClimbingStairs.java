package december_2025;

import java.util.Arrays;

public class MinCostClimbingStairs {

    // O(n) time | O(1) space
    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] = cost[i] + Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }

    // O(n) time | O(n) space
    public int minCostClimbingStairs2(int[] cost) {
        int[] memo = new int[cost.length];
        Arrays.fill(memo, -1);
        return Math.min(helper(cost, 0, memo), helper(cost, 1, memo));
    }

    private int helper(int[] cost, int i, int[] memo) {
        if (i >= cost.length) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }

        memo[i] = cost[i] + Math.min(helper(cost, i + 1, memo), helper(cost, i + 2, memo));

        return memo[i];
    }


}
