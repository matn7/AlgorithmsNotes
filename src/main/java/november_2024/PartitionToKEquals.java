package november_2024;

import java.util.Arrays;
import java.util.Comparator;

public class PartitionToKEquals {

    public static void main(String[] args) {
//        int[] nums = {1, 1, 1, 1, 1, 3, 3, 4, 5};
//        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int[] nums = {4,4,6,2,3,8,10,2,10,7};
        int k = 4;
        PartitionToKEquals partitionToKEquals = new PartitionToKEquals();
        boolean result = partitionToKEquals.canPartitionKSubsets(nums, k);
        System.out.println(result);
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int target = sum / k;
        boolean[] used = new boolean[nums.length];

        return backtrack(0, k, 0, target, nums, used);
    }

    private boolean backtrack(int i, int k, int subsetSum, int target, int[] nums, boolean[] used) {
        if (k == 0) {
            return true;  // All subsets have been formed
        }
        if (subsetSum == target) {
            // When the current subset sum equals the target, start the next subset
            return backtrack(0, k - 1, 0, target, nums, used);  // Reset subset sum and reduce k
        }

        for (int j = i; j < nums.length; j++) {
            if (used[j] || subsetSum + nums[j] > target) {
                continue;
            }
            used[j] = true;
            if (backtrack(j + 1, k, subsetSum + nums[j], target, nums, used)) {
                return true;
            }
            used[j] = false;
        }
        return false;
    }

}
