package april_2025;

import java.util.Arrays;

public class JumpGameII {

    // O(n^2) time | O(n) space
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            for (int j = 1; j < n + 1; j++) {
                if (i + j < dp.length) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                    if (i + j == dp.length - 1) {
                        return dp[dp.length - 1];
                    }
                } else {
                    break;
                }
            }
        }

        return dp[dp.length - 1];
    }

}
