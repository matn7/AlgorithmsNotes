package june_2025;

import java.util.HashMap;
import java.util.Map;

public class TargetSum3 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        TargetSum3 targetSum3 = new TargetSum3();
        int result = targetSum3.findTargetSumWays(nums, target);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();
        return dfs(nums, 0, 0, target, dp);
    }

    private int dfs(int[] nums, int idx, int sum, int target, Map<String, Integer> dp) {
        if (idx == nums.length) {
            return sum == target ? 1 : 0;
        }
        String key = idx + ":" + sum;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        dp.put(key, dfs(nums, idx + 1, sum + nums[idx], target, dp) +
                dfs(nums, idx + 1, sum - nums[idx], target, dp));
        return dp.get(key);
    }

}
