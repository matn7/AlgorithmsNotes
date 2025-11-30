package november_2025;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] cost = {10,15,20};

        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        int result = minCostClimbingStairs.minCostClimbingStairs(cost);
        System.out.println(result);

    }

    // O(n) time | O(n) space
    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] = Math.min(cost[i] + cost[i - 1], cost[i] + cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }

    // O(n * m) time | O(n * m) space
    public int minCostClimbingStairs2(int[] cost) {
//        int[] dp = new int[cost.length + 1];
        Map<String, Integer> dp = new HashMap<>();
        return Math.min(dfs(cost, 0, 0, dp), dfs(cost, 1, 0, dp));

    }

    private int dfs(int[] cost, int i, int sum,  Map<String, Integer> dp) {
        if (i >= cost.length) {
            return sum;
        }
        String key = i + ":" + sum;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
//        if (dp[i] != Integer.MAX_VALUE) {
//            return dp[i];
//        }

        int res = Math.min(dfs(cost, i + 1, sum + cost[i], dp), dfs(cost, i + 2, sum + cost[i], dp));
//        dp[i] = res;
        dp.put(key, res);
        return res;
    }

}
