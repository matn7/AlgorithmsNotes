package july_2025;

public class MaxSumCircularSubArr {

    public static void main(String[] args) {
        int[] nums = {-3,-2,-3};
        MaxSumCircularSubArr maxSumCircularSubArr = new MaxSumCircularSubArr();
        int result = maxSumCircularSubArr.maxSubarraySumCircular(nums);
        System.out.println(result);
    }

    public int maxSubarraySumCircular(int[] nums) {
        int currMax = 0;
        int currMin = 0;
        int globalMax = nums[0];
        int globalMin = nums[0];
        int total = 0;

        for (int num : nums) {
            currMax = Math.max(num, num + currMax);
            currMin = Math.min(num, num + currMin);
            globalMax = Math.max(globalMax, currMax);
            globalMin = Math.min(globalMin, currMin);
            total += num;
        }

        return globalMax < 0 ? globalMax : Math.max(globalMax, total - globalMin);
    }

}
