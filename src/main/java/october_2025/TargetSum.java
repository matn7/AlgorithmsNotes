package october_2025;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;

        TargetSum targetSum = new TargetSum();
        int result = targetSum.findTargetSumWays(nums, target);

        System.out.println(result);
    }

    // O(n * s) time | O(n * s) space
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        if (Math.abs(target) > total) {
            return 0;
        }

        int[][] memo = new int[nums.length][2 * total + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(nums, 0, 0, target, memo, total);
    }

    private int dfs(int[] nums, int i, int sum, int target, int[][] memo, int offset) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }
        if (memo[i][sum + offset] != -1) {
            return memo[i][sum + offset];
        }
        int count = 0;
        count += dfs(nums, i + 1, sum + nums[i], target, memo, offset);
        count += dfs(nums, i + 1, sum - nums[i], target, memo, offset);

        memo[i][sum + offset] = count;
        return count;
    }

}
