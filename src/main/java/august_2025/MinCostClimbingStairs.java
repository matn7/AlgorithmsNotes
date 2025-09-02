package august_2025;

import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};

        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        int result = minCostClimbingStairs.minCostClimbingStairs(cost);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];

        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[dp.length - 1];
    }


    // O(n) time | O(n) space
    public int minCostClimbingStairs2(int[] cost) {
        Map<Integer, Integer> memo = new HashMap<>();
        return Math.min(dfs(0, cost, memo), dfs(1, cost, memo));
    }

    private int dfs(int pos, int[] cost, Map<Integer, Integer> memo) {
        if (pos >= cost.length) {
            return 0;
        }
        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }
        memo.put(pos, cost[pos] + Math.min(dfs(pos + 1, cost, memo), dfs(pos + 2, cost, memo)));
        return memo.get(pos);
    }

}
