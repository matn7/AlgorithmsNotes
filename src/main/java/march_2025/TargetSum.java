package march_2025;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    // O(n * m) time | O(n * m) space
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();
        return backtrack(nums, target, 0, 0, dp);
    }

    private int backtrack(int[] nums, int target, int i, int curSum, Map<String, Integer> dp) {
        String key = i + ":" + curSum;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        if (i == nums.length) {
            return curSum == target ? 1 : 0;
        }
        dp.put(key, backtrack(nums, target, i + 1, curSum + nums[i], dp) +
                backtrack(nums, target, i + 1, curSum - nums[i], dp));
        return dp.get(key);
    }

}
