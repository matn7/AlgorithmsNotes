package november_2024;

import java.util.HashMap;
import java.util.Map;

public class FindTarget {

    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();
        return backtrack(0, 0, nums, target, dp);
    }

    private int backtrack(int i, int total, int[] nums, int target, Map<String, Integer> dp) {
        if (i == nums.length) {
            return total == target ? 1 : 0;
        }
        String key = getKey(i, total);
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        dp.put(key, backtrack(i + 1, total + nums[i], nums, target, dp) +
                backtrack(i + 1, total - nums[i], nums, target, dp));
        return dp.get(key);
    }

    private String getKey(int i, int total) {
        return i + ":" + total;
    }

}
