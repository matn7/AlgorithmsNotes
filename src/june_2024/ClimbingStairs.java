package june_2024;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public static void main(String[] args) {
        int[] cost = {20, 15, 30, 5};

        int result = minCostClimbingStairs(cost);
        System.out.println(result);

        int result2 = minCostClimbingStairsMemo(cost);
        System.out.println(result2);
    }

    // O(n) time | O(n) space
    public static int minCostClimbingStairsMemo(int[] cost) {
        int n = cost.length;
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, cost[0]);
        cache.put(1, cost[1]);
        return Math.min(minCostMemo(n - 1, cost, cache), minCostMemo(n - 2 ,cost, cache));
    }

    private static int minCostMemo(int i, int[] cost, Map<Integer, Integer> cache) {
        if (i < 0) {
            return 0;
        }
        if (cache.containsKey(i)) {
            return cache.get(i);
        }
        cache.put(i, cost[i] + Math.min(minCostMemo(i - 1, cost, cache), minCostMemo(i - 2, cost, cache)));
        return cache.get(i);
    }

    // O(2^n) time | O(n) space
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return Math.min(minCost(n - 1, cost), minCost(n - 2 ,cost));
    }

    private static int minCost(int i, int[] cost) {
        if (i < 0) {
            return 0;
        }
        if (i == 0 || i == 1) {
            return cost[i];
        }
        return cost[i] + Math.min(minCost(i - 1, cost), minCost(i - 2, cost));
    }

}
