package december_2024;

import java.util.Arrays;

public class ClimbingStairsII {

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};

        ClimbingStairsII climbingStairsII = new ClimbingStairsII();
        int result = climbingStairsII.minCostClimbingStairs(cost);
        System.out.println(result);
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] newCosts = new int[cost.length + 1];
        System.arraycopy(cost, 0, newCosts, 0, cost.length);

        for (int i = newCosts.length - 3; i >= 0; i--) {
            newCosts[i] = newCosts[i] + Math.min(newCosts[i + 1], newCosts[i + 2]);
        }

        return Math.min(newCosts[0], newCosts[1]);
    }

}
