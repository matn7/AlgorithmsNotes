package october_2025;

import java.util.*;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
//        int[] nums = {1, 5, 11, 5};
        int[] nums = {1,2,3,4};
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        boolean result = partitionEqualSubsetSum.canPartition(nums);
        System.out.println(result);
    }

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
        Arrays.sort(nums);
        Map<String, Boolean> memo = new HashMap<>();
        return backtrack(nums, 0, 0, target, memo);
    }

    private boolean backtrack(int[] nums, int i, int sum, int target, Map<String, Boolean> memo) {
        if (sum == target) {
            return true;
        }
        String key = i + ":" + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (i >= nums.length) {
            return false;
        }
        memo.put(key, backtrack(nums, i + 1, sum + nums[i], target, memo) || backtrack(nums, i + 1, sum, target, memo));
        return memo.get(key);
    }


    // O(n * s) time | O(s) space
    // n - num elements
    // s - sum of elems in nums
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
            Set<Integer> nextDp = new HashSet<>();

            for (int n : dp) {
                int curr = n + num;
                if (curr == target) {
                    return true;
                }
                nextDp.add(curr);
                nextDp.add(n);
            }

            dp = nextDp;
        }

        return false;
    }


}
