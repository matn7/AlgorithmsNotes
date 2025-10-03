package september_2025;

public class MaxSumCircularSubarray {

    public static void main(String[] args) {
        int[] nums = {5,-3,5};

        MaxSumCircularSubarray maxSumCircularSubarray = new MaxSumCircularSubarray();
        int result = maxSumCircularSubarray.maxSubarraySumCircular(nums);
        System.out.println(result);

    }

    // O(n) time | O(1) space
    public int maxSubarraySumCircular(int[] nums) {
        int globalMax = nums[0];
        int currMax = 0;
        int globalMin = nums[0];
        int currMin = 0;
        int total = 0;

        for (int num : nums) {
            currMax = Math.max(num, currMax + num);
            globalMax = Math.max(globalMax, currMax);

            currMin = Math.min(num, currMin + num);
            globalMin = Math.min(globalMin, currMin);

            total += num;
        }

        return globalMax < 0 ? globalMax : Math.max(globalMax, total - globalMin);
    }

}
