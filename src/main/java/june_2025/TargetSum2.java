package june_2025;

import java.util.HashMap;
import java.util.Map;

public class TargetSum2 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        TargetSum2 targetSum2 = new TargetSum2();

        int result = targetSum2.findTargetSumWays(nums, target);
        System.out.println(result);

    }

    // O(n * m) time | O(n * m) space
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(nums, 0, 0, target, memo);
    }

    private int dfs(int[] nums, int i, int sum, int target, Map<String, Integer> memo) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }
        String key = i + ":" + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int res = dfs(nums, i + 1, sum + nums[i], target, memo)
                + dfs(nums, i + 1, sum - nums[i], target, memo);
        memo.put(key, res);
        return res;
    }

}
