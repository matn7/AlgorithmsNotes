package july_2025;

public class MaxSumCircular {

    public static void main(String[] args) {
        int[] nums = {5,-3,5};
//        int[] nums = {1,-2,3,-2};

        MaxSumCircular maxSumCircular = new MaxSumCircular();
        int result = maxSumCircular.maxSubarraySumCircular(nums);
        System.out.println(result);
    }

    // Intuition:
    // - some kind of modified max sum subarray
    // - module, index wraparound
    // - counts
    // Approach:
    // - modified Kadane's
    // Complexity:
    // O(n) time | O(1) space
    // Code:

    // [5, -3, 5] -> [7]
    // [5, -3, 5] -> [10] = total - globalMin
    public int maxSubarraySumCircular(int[] nums) {
        int globalMax = nums[0];
        int globalMin = nums[0];
        int curMax = 0;
        int curMin = 0;
        int total = 0;

        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            curMin = Math.min(curMin + num, num);
            globalMax = Math.max(globalMax, curMax);
            globalMin = Math.min(globalMin, curMin);
            total += num;
        }

        return globalMax < 0 ? globalMax : Math.max(globalMax, total - globalMin);
    }

}
