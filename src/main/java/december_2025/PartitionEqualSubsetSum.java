package december_2025;

import java.util.*;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        boolean result = partitionEqualSubsetSum.canPartition(nums);
        System.out.println(result);
    }

    // O(2^n) time | O(n) space
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        for (int num : nums) {
            Set<Integer> nextDp = new HashSet<>();
            for (int t : dp) {
                if (t + num == target) {
                    return true;
                }
                nextDp.add(t);
                nextDp.add(t + num);
            }
            dp = nextDp;
        }
        return false;
    }

    private boolean dfs(int[] nums, int i, int sum, int target, Map<String, Boolean> memo) {
        if (sum == target) {
            return true;
        }
        if (i == nums.length || sum > target) {
            return false;
        }
        String key = i + ":" + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        memo.put(key, dfs(nums, i + 1, sum + nums[i], target, memo) || dfs(nums, i + 1, sum, target, memo));
        return memo.get(key);
    }

}
