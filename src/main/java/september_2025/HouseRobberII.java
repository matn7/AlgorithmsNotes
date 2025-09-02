package september_2025;

import java.util.Arrays;

public class HouseRobberII {

    public static void main(String[] args) {
        int[] nums = {0};
        HouseRobberII houseRobberII = new HouseRobberII();
        int result = houseRobberII.rob(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] a = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] b = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(helper(a), helper(b));
    }

    private int helper(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }

}
