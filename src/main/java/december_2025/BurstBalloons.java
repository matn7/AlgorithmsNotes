package december_2025;

public class BurstBalloons {

    public static void main(String[] args) {
        int[] nums = {3,1,5,8};

        BurstBalloons burstBalloons = new BurstBalloons();
        int result = burstBalloons.maxCoins(nums);
        System.out.println(result);
    }

    // O(n^3) time | O(n^2) space
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        newNums[0] = 1;
        newNums[newNums.length - 1] = 1;

        for (int i = 1; i < newNums.length - 1; i++) {
            newNums[i] = nums[i - 1];
        }

        int[][] dp = new int[newNums.length + 1][newNums.length + 1];
        for (int r = 0; r < dp.length; r++) {
            for (int c = 0; c < dp[r].length; c++) {
                dp[r][c] = -1;
            }
        }

        return dfs(newNums, 1, newNums.length - 2, dp);
    }

    private int dfs(int[] nums, int l, int r, int[][] dp) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        dp[l][r] = 0;
        for (int i = l; i <= r; i++) {
            int coins = nums[l - 1] * nums[i] * nums[r + 1];
            coins += dfs(nums, l, i - 1, dp) + dfs(nums, i + 1, r, dp);
            dp[l][r] = Math.max(dp[l][r], coins);
        }
        return dp[l][r];
    }

}
