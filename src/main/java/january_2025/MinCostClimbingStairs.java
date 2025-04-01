package january_2025;

import java.util.Arrays;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
//        int[] cost = {10, 15, 20};
        int[] cost = {1,100,1,1,1,100,1,1,100,1};

        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        int result = minCostClimbingStairs.minCostClimbingStairs(cost);
        System.out.println(result);
    }


    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] = cost[i] + Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }

    public int minCostClimbingStairs2(int[] cost) {
        int[] newCost = new int[cost.length + 1];
        System.arraycopy(cost, 0, newCost, 0, cost.length);

        int[] costs = new int[cost.length + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[0] = cost[0];
        costs[1] = cost[1];
        costs[costs.length - 1] = 0;

        for (int i = 2; i < costs.length; i++) {
            costs[i] = newCost[i] + Math.min(costs[i - 1], costs[i - 2]);
        }
        return costs[costs.length - 1];
    }

}
