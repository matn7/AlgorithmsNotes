package october_2024;

public class PaintHouse2 {

    public static void main(String[] args) {
        int[][] costs = {{17,2,17}, {16,16,5}, {14,3,19}};

        PaintHouse2 paintHouse2 = new PaintHouse2();
        int result = paintHouse2.minCost(costs);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int minCost(int[][] costs) {
        int[] dp = {0, 0, 0};

        for (int i = 0; i < costs.length; i++) {
            int dp0 = costs[i][0] + Math.min(dp[1], dp[2]);
            int dp1 = costs[i][1] + Math.min(dp[0], dp[2]);
            int dp2 = costs[i][2] + Math.min(dp[0], dp[1]);
            dp[0] = dp0;
            dp[1] = dp1;
            dp[2] = dp2;
        }

        int min = Integer.MAX_VALUE;
        for (int d : dp) {
            min = Math.min(d, min);
        }
        return min;
    }

}
