package june_2025;

import java.util.Arrays;

public class MinCostClimbingStairs2 {

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};

        MinCostClimbingStairs2 minCostClimbingStairs2 = new MinCostClimbingStairs2();
        int result = minCostClimbingStairs2.minCostClimbingStairs(cost);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] cache = new int[n + 1];

        for (int i = 2; i <= cost.length; i++) {
            cache[i] = Math.min(cost[i - 1] + cache[i - 1], cost[i - 2] + cache[i - 2]);
        }
        return cache[n];
    }

    // O(n) time | O(n) space
    public int minCostClimbingStairs2(int[] cost) {
        int[] cache = new int[cost.length];
        Arrays.fill(cache, -1);
        return Math.min(dfs(cost, 0, cache), dfs(cost, 1, cache));
    }

    private int dfs(int[] cost, int pos, int[] cache) {
        if (pos >= cost.length) {
            return 0;
        }
        if (cache[pos] != -1) {
            return cache[pos];
        }
        cache[pos] = cost[pos] + Math.min(dfs(cost, pos + 1, cache), dfs(cost, pos + 2, cache));
        return cache[pos];
    }


}
