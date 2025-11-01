package october_2025;

import java.util.Arrays;

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        HouseRobber houseRobber = new HouseRobber();
        int result = houseRobber.rob(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dfs(nums, 0, memo);
    }

    private int dfs(int[] nums, int pos, int[] memo) {
        if (pos >= nums.length) {
            return 0;
        }
        if (memo[pos] != -1) {
            return memo[pos];
        }
        memo[pos] = Math.max(dfs(nums, pos + 1, memo), nums[pos] + dfs(nums, pos + 2, memo));
        return memo[pos];
    }

    // O(n) time | O(1) space
    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
//        int[] result = new int[nums.length];
//        Arrays.fill(result, Integer.MIN_VALUE);

        // result[0] = nums[0]; // a
        int a = nums[0];
        // result[1] = Math.max(nums[0], nums[1]); // b
        int b = Math.max(nums[0], nums[1]);
        int c = 0;

        for (int i = 2; i < nums.length; i++) {
            // result[i] = Math.max(result[i - 1], nums[i] + a);
            c = Math.max(b, nums[i] + a);
            a = b;
            b = c;
        }
        // return result[result.length - 1];
        return b;
    }

}
