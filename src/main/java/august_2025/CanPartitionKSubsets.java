package august_2025;

import java.util.Arrays;

public class CanPartitionKSubsets {

    // O(k * 2^n) time | O(n) space
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        reverse(nums);
        int target = sum / k;
        boolean[] used = new boolean[nums.length];

        return backtrack(nums, target, used, 0, k, 0);
    }

    private boolean backtrack(int[] nums, int target, boolean[] used, int i, int k, int subsetSum) {
        if (k == 0) {
            return true;
        }
        if (subsetSum == target) {
            return backtrack(nums, target, used, 0, k - 1, 0);
        }

        for (int j = i; j < nums.length; j++) {
            if (used[j] || subsetSum + nums[j] > target) {
                continue;
            }
            used[j] = true;
            if (backtrack(nums, target, used, j + 1, k, subsetSum + nums[j])) {
                return true;
            }
            used[j] = false;
        }
        return false;
    }
    
    private void reverse(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        
        while (i <= j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

}
