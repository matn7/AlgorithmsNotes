package june_2025;

public class MaxSumCircular {


    public static void main(String[] args) {
//        int[] nums = {1,-2,3,-2};
        int[] nums = {5,-3,5};

        MaxSumCircular maxSumCircular = new MaxSumCircular();
        int result = maxSumCircular.maxSubarraySumCircular(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxSubarraySumCircular(int[] nums) {
        int globalMax = nums[0];
        int globalMin = nums[0];

        int curMax = 0;
        int curMin = 0;

        int sum = 0;

        for (int num : nums) {
            sum += num;
            curMax = Math.max(num, curMax + num);
            curMin = Math.min(num, curMin + num);

            globalMax = Math.max(globalMax, curMax);
            globalMin = Math.min(globalMin, curMin);
        }

        return globalMax > 0 ? Math.max(globalMax, sum - globalMin) : globalMax;
    }

}
