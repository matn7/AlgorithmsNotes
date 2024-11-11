package november_2024;

import java.util.Arrays;

public class MinimumDifference {

    public static void main(String[] args) {
        int[] nums = {9, 4, 1, 7};
        int k = 2;

        MinimumDifference minimumDifference = new MinimumDifference();
        minimumDifference.minimumDifference(nums, k);
    }

    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;  // If there's only one element in the subarray, difference is always 0.

        Arrays.sort(nums);  // Sort the array

        int minDifference = Integer.MAX_VALUE;

        // Slide a window of size 'k' through the array
        for (int i = 0; i <= nums.length - k; i++) {
            int currentDifference = nums[i + k - 1] - nums[i];  // Max value - Min value in the current window
            minDifference = Math.min(minDifference, currentDifference);
        }

        return minDifference;
    }

}
