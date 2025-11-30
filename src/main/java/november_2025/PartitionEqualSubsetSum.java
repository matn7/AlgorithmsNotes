package november_2025;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};

        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        boolean result = partitionEqualSubsetSum.canPartition(nums);
        System.out.println(result);
    }

    // O(2^n) time | O(n) space
    // O(n) time | O(n) space
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        Map<String, Boolean> memo = new HashMap<>();
        boolean[][] memo2 = new boolean[nums.length + 1][sum + 1];

        return backtrack(nums, 0, 0, target, memo, memo2);
    }

    private boolean backtrack(int[] nums, int i, int sum, int target, Map<String, Boolean> memo, boolean[][] memo2) {
        if (sum == target) {
            return true;
        }
        if (i == nums.length) {
            return false;
        }
        if (memo2[i][sum]) {
            return true;
        }
        memo2[i][sum] = backtrack(nums, i + 1, sum + nums[i], target, memo, memo2) ||
                backtrack(nums, i + 1, sum, target, memo, memo2);
        return memo2[i][sum];
    }

    // O(n*s) time | O(n) space
    // n - num elements
    // s - sum of all elems
    public boolean canPartition2(int[] nums) {
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
            Set<Integer> newDp = new HashSet<>();
            for (int d : dp) {
                if (d + num == target) {
                    return true;
                }
                newDp.add(d + num);
                newDp.add(d);
            }
            dp = newDp;
        }
        return false;
    }

}
