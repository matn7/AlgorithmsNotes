package september_2025;

public class LastStoneWeightII {

    // O(n * m) time | O(n * m) space
    // n - number of stones
    // m - sum of weights of stones
    int[][] dp;
    public int lastStoneWeightII(int[] stones) {
        int stoneSum = 0;
        for (int stone : stones) {
            stoneSum += stone;
        }

        int target = (stoneSum + 1) / 2; // round up
        dp = new int[stones.length][target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }

        return dfs(0, 0, target, stoneSum, stones);
    }

    private int dfs(int i, int total, int target, int stoneSum, int[] stones) {
        if (total >= target || i == stones.length) {
            // 23, 12, 11
            return Math.abs(total - (stoneSum - total));
        }
        if (dp[i][total] != -1) {
            return dp[i][total];
        }

        dp[i][total] = Math.min(
                dfs(i + 1, total, target, stoneSum, stones),
                dfs(i + 1, total + stones[i], target, stoneSum, stones));
        return dp[i][total];
    }

}
