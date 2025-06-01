package may_2025;

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

    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> cache = new HashMap<>();
        return dfs(0, nums, 0, target, cache);
    }

    private int dfs(int i, int[] nums, int sum, int target, Map<String, Integer> cache) {
        String key = i + ":" + sum;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }

        int res = 0;
        res += dfs(i + 1, nums, sum + nums[i], target, cache);
        res += dfs(i + 1, nums, sum - nums[i], target, cache);
        cache.put(key, res);
        return res;
    }


}
