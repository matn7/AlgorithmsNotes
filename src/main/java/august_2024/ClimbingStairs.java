package august_2024;

public class ClimbingStairs {

    public static void main(String[] args) {
        int[] cost = {20, 15, 30, 5};

        int result = climbingStairs(cost);
        System.out.println(result);
    }

    public static int climbingStairs(int[] cost) {
        int[] result = new int[cost.length];

        result[0] = cost[0];
        result[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            result[i] = cost[i] + Math.min(cost[i - 1], result[i - 2]);
        }
        return result[cost.length - 1];
    }


}
