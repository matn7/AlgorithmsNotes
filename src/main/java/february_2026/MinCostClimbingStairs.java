package february_2026;

import java.util.Arrays;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};

        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        int result = minCostClimbingStairs.minCostClimbingStairs(cost);
        System.out.println(result);
    }

    // O(2^n) time | O(n) space
    // O(n) time | O(n) space
    int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length];
        Arrays.fill(memo, -1);
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    private int dfs(int[] cost, int i) {
        if (i >= cost.length) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        memo[i] = cost[i] + Math.min(dfs(cost, i + 1), dfs(cost, i + 2));
        return memo[i];
    }

    // O(n) time | O(1) space
    public int minCostClimbingStairs2(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] = cost[i] + Math.min(cost[i - 1], cost[i - 2]);
        }
        int i = cost.length - 1;
        return Math.min(cost[i], cost[i - 1]);
    }

}
