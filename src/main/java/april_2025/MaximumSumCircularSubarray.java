package april_2025;

public class MaximumSumCircularSubarray {

    public static void main(String[] args) {
        int[] nums = {5, -3, 5};

        MaximumSumCircularSubarray maximumSumCircularSubarray = new MaximumSumCircularSubarray();
        int result = maximumSumCircularSubarray.maxSubarraySumCircular(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) sspace
    public int maxSubarraySumCircular(int[] nums) {
        int curMax = 0;
        int globalMax = nums[0];

        int curMin = 0;
        int globalMin = nums[0];

        int total = 0;

        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            globalMax = Math.max(globalMax, curMax);

            curMin = Math.min(curMin + num, num);
            globalMin = Math.min(globalMin, curMin);

            total += num;
        }

        return globalMax < 0 ? globalMax : Math.max(globalMax, total - globalMin);
    }

}
