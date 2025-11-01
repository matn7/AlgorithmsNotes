package october_2025;

public class MaximumSumCircularSubarray {

    public static void main(String[] args) {
        int[] nums = {5,-3,5};

//        int[] nums = {1,-2,3,-2};

//        int[] nums = {-3,-2,-3};

        MaximumSumCircularSubarray maximumSumCircularSubarray = new MaximumSumCircularSubarray();
        int result = maximumSumCircularSubarray.maxSubarraySumCircular(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxSubarraySumCircular(int[] nums) {
        int maxSoFar = nums[0];
        int maxHere = 0;
        int minSoFar = nums[0];
        int minHere = 0;
        int total = 0;

        for (int num : nums) {
            maxHere = Math.max(num, maxHere + num);
            maxSoFar = Math.max(maxHere, maxSoFar);

            minHere = Math.min(num, minHere + num);
            minSoFar = Math.min(minHere, minSoFar);

            total += num;
        }
        return maxSoFar < 0 ? maxSoFar : Math.max(maxSoFar, total - minSoFar);
    }

}
