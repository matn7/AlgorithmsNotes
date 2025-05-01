package april_2025;

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

    // O(2^n) time | O(n) space - not optimal
    // O(n * m) time | O(n * m) space - memo
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();
        return backtrack(nums, target, 0, 0, dp);
    }

    private int backtrack(int[] nums, int target, int idx, int sum, Map<String, Integer> dp) {
        String key = idx + ":" + sum;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        if (idx == nums.length) {
            return sum == target ? 1 : 0;
        }

        dp.put(key, backtrack(nums, target, idx + 1, sum + nums[idx], dp) +
                backtrack(nums, target, idx + 1, sum - nums[idx], dp));
        return dp.get(key);
    }

}
