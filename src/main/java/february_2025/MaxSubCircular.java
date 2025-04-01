package february_2025;

public class MaxSubCircular {

    public static void main(String[] args) {
        int[] nums = {1, -2, 3, -2, 8};

        MaxSubCircular maxSubCircular = new MaxSubCircular();
        int result = maxSubCircular.maxSubarraySumCircular(nums);
        System.out.println(result);
    }

    public int maxSubarraySumCircular(int[] nums) {
        int globalMax = nums[0];
        int curMax = 0;
        int globalMin = nums[0];
        int curMin = 0;
        int total = 0;
        for (int num : nums) {
            curMax = Math.max(num, curMax + num);
            globalMax = Math.max(globalMax, curMax);
            curMin = Math.min(num, curMin + num);
            globalMin = Math.min(globalMin, curMin);
            total += num;
        }
        return globalMax > 0 ? Math.max(globalMax, total - globalMin) : globalMax;
    }

}
