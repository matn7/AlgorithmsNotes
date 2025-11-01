package october_2025;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
//        int[] cost = {10, 15, 20};

//        int[] cost = {10, 15};

        int[] cost = {1,100,1,1,1,100,1,1,100,1};

        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        int result = minCostClimbingStairs.minCostClimbingStairs(cost);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int minCostClimbingStairs(int[] cost) {
//        int[] res = new int[cost.length + 1];
//        Arrays.fill(res, Integer.MAX_VALUE);
//        a = res[res.length - 1]
//        b = cost[cost.length - 1];
//        res[res.length - 1] = 0;
//        res[res.length - 2] = cost[cost.length - 1];
        int a = 0;
        int b = cost[cost.length - 1];
        int c;

        for (int i = cost.length - 2; i >= 0; i--) {
            // res[i] = Math.min(cost[i] + res[i + 1], cost[i] + res[i + 2]);
            c = Math.min(cost[i] + a, cost[i] + b);
            a = b;
            b = c;
        }
//        return Math.min(res[0], res[1]);
        return Math.min(a, b);
    }

    // O(n) time | O(n) space
    public int minCostClimbingStairs2(int[] cost) {
        Map<Integer, Integer> memo = new HashMap<>();
        return Math.min(dfs(cost, 0, memo), dfs(cost, 1, memo));
    }

    private int dfs(int[] cost, int pos, Map<Integer, Integer> memo) {
        if (pos >= cost.length) {
            return 0;
        }
        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }
        memo.put(pos, cost[pos] + Math.min(dfs(cost, pos + 1, memo), dfs(cost, pos + 2, memo)));
        return memo.get(pos);
    }

}
