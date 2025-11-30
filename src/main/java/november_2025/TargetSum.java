package november_2025;

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
        Map<String, Integer> memo = new HashMap<>();
        return dfs(nums, 0, 0, target, memo);
    }

    private int dfs(int[] nums, int i, int sum, int target, Map<String, Integer> memo) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }
        if (i > nums.length) {
            return 0;
        }
        String key = i + ":" + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        memo.put(key, dfs(nums, i + 1, sum + nums[i], target, memo) + dfs(nums, i + 1, sum - nums[i], target, memo));
        return memo.get(key);
    }

}
