package april_2025;

import java.util.Arrays;

public class BurstBalloons {

    // O(n^3) time | O(n^2) space
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        newNums[0] = 1;
        newNums[newNums.length - 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, nums.length);

        int[][] dp = new int[newNums.length + 1][newNums.length + 1];
        for (int r = 0; r < dp.length; r++) {
            Arrays.fill(dp[r], -1);
        }
        return dfs(1, newNums.length - 2, newNums, dp);
    }

    private int dfs(int l, int r, int[] nums, int[][] dp) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        dp[l][r] = 0;
        for (int i = l; i < r + 1; i++) {
            int coins = nums[l - 1] * nums[i] * nums[r + 1];
            coins += dfs(l, i - 1, nums, dp) + dfs(i + 1, r, nums, dp);
            dp[l][r] = Math.max(dp[l][r], coins);
        }
        return dp[l][r];
    }

}
