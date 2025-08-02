package july_2025;

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

    // O(n * m) time | O(n * m) space
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();
        return dfs(nums, 0, 0, target, dp);
    }

    private int dfs(int[] nums, int i, int sum, int target, Map<String, Integer> dp) {
        if (i == nums.length) {
            return target == sum ? 1 : 0;
        }
        String key = i + ":" + sum;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int res = dfs(nums, i + 1, sum + nums[i], target, dp)
                + dfs(nums, i + 1, sum - nums[i], target, dp);
        dp.put(key, res);
        return dp.get(key);
    }

}
