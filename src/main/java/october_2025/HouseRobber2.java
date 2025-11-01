package october_2025;

import september_2024.IsUnique;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber2 {

    // O(n) time | O(n) space
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> memo = new HashMap<>();
        return helper(nums, 0, memo);
    }

    private int helper(int[] nums, int i, Map<Integer, Integer> memo) {
        if (i >= nums.length) {
           return 0;
        }
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        memo.put(i, Math.max(helper(nums, i + 1, memo), nums[i] + helper(nums, i + 2, memo)));
        return memo.get(i);
    }

    // O(n) time | O(n) space
    public int rob1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[dp.length - 1];
    }

    // O(n) time | O(1) space
    public int rob2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int a = nums[0];
        int b = Math.max(a, nums[1]);
        int c = b;
        for (int i = 2; i < nums.length; i++) {
            c = Math.max(b, nums[i] + a);
            a = b;
            b = c;
        }
        return b;
    }

}
