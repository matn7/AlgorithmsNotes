package april_2025;

import java.util.Arrays;

public class DistributeBonuses {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3, 1};

        DistributeBonuses distributeBonuses = new DistributeBonuses();
        int[] result = distributeBonuses.distributeBonuses(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] distributeBonuses(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                dp[i] = Math.max(dp[i], dp[i + 1] + 1);
            }
        }

        return dp;
    }

}
