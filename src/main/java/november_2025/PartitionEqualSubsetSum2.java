package november_2025;

import java.util.*;

public class PartitionEqualSubsetSum2 {

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
//        int[] nums = {1,2,3,4};

        PartitionEqualSubsetSum2 partitionEqualSubsetSum2 = new PartitionEqualSubsetSum2();
        boolean result = partitionEqualSubsetSum2.canPartition(nums);
        System.out.println(result);

    }

    // O(n * s) time | O(s) space
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
            for (int d : dp) {
                if (num + d == target) {
                    return true;
                }
                nextDp.add(d);
                nextDp.add(num + d);
            }
            dp = nextDp;
        }
        return false;
    }

    // O(2^n) time | O(n) space
    // O(n * s) time | O(n * s) space
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        Arrays.sort(nums);

        int target = sum / 2;
        Map<String, Boolean> memo = new HashMap<>();
        return backtrack(nums, 0, 0, target, memo);
    }

    private boolean backtrack(int[] nums, int i, int sum, int target, Map<String, Boolean> memo) {
        if (sum == target) {
            return true;
        }
        if (i >= nums.length || sum > target) {
            return false;
        }
        String key = i + ":" + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        memo.put(key, backtrack(nums, i + 1, sum + nums[i], target, memo) || backtrack(nums, i + 1, sum, target, memo));
        return memo.get(key);
    }

}
