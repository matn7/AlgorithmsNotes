package june_2025;

import java.util.Arrays;

public class HouseRobber2 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        HouseRobber2 houseRobber2 = new HouseRobber2();
        int result = houseRobber2.rob(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return dfs(nums, 0, dp);
    }

    private int dfs(int[] nums, int i, int[] dp) {
        if (i >= nums.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        dp[i] = Math.max(dfs(nums, i + 1, dp), nums[i] + dfs(nums, i + 2, dp));
        return dp[i];
    }

    // O(n) time | O(n) space
    public int rob2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[dp.length - 1];
    }

}
