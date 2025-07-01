package june_2025;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        TargetSum targetSum = new TargetSum();
        int result = targetSum.findTargetSumWays(nums, target);
        System.out.println(result);
    }

    // O(n*m) time | O(n*m) space
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();
        return backtrack(0, 0, nums, target, dp);
    }

    private int backtrack(int i, int sum, int[] nums, int target, Map<String, Integer> dp) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }
        String key = i + ":" + sum;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        dp.put(key, backtrack(i + 1, sum + nums[i], nums, target, dp) +
                backtrack(i + 1, sum - nums[i], nums, target, dp));
        return dp.get(key);
    }

}
