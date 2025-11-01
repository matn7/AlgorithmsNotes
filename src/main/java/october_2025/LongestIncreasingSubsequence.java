package october_2025;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        int result = longestIncreasingSubsequence.lengthOfLIS(nums);
        System.out.println(result);
    }

    // O(n^2) time | O(n) space
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

}
