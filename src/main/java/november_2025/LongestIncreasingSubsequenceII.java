package november_2025;

import java.util.Arrays;

public class LongestIncreasingSubsequenceII {

    // O(n^2) time | O(n) space
    public int lengthOfLIS(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] >= nums[i]) {
                    continue;
                }
                if (nums[i] - nums[j] <= k) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

}
