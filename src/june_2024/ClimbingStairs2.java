package june_2024;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs2 {

    public static void main(String[] args) {
        int[] cost = {20, 15, 30, 5};

        int result = minCostClimbingStairs(cost);
        System.out.println(result);

        int result2 = minCostClimbingStairs2(cost);
        System.out.println(result2);
    }

    // O(n) time | O(1) space
    public static int minCostClimbingStairs2(int[] cost) {
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


    // O(n) time | O(n) space
    public static int minCostClimbingStairs(int[] cost) {
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

}
