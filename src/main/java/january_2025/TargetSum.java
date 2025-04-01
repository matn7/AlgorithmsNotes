package january_2025;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    Map<String, Integer> dp = new HashMap<>(); // (idx, total) -> num of ways

    // O(n*m) time | O(n*m) space
    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(0, 0, nums, target);
    }

    private int backtrack(int i, int total, int[] nums, int target) {
        if (i == nums.length) {
            return total == target ? 1 : 0;
        }
        String key = i + ":" + total;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        dp.put(key, backtrack(i + 1, total + nums[i], nums, target)
                + backtrack(i + 1, total - nums[i], nums, target));
        return dp.get(key);
    }

}
