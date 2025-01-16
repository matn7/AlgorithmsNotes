package december_2024;

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
        Map<String, Integer> dp = new HashMap<>();
        return backtrack(0, 0, nums, target, dp);
    }

    private int backtrack(int i, int currSum, int[] nums, int target, Map<String, Integer> dp) {
        String key = i + ":" + currSum;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        if (i == nums.length) {
            return currSum == target ? 1 : 0;
        }
        dp.put(key, backtrack(i + 1, currSum + nums[i], nums, target, dp)
                + backtrack(i + 1, currSum - nums[i], nums, target, dp));
        return dp.get(key);
    }

}
