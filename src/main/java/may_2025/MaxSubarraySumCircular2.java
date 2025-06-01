
package may_2025;

public class MaxSubarraySumCircular2 {

    public static void main(String[] args) {
        int[] nums = {1, -2, 3, -2};

        MaxSubarraySumCircular2 maxSubarraySumCircular = new MaxSubarraySumCircular2();
        int result = maxSubarraySumCircular.maxSubarraySumCircular(nums);
        System.out.println(result);
    }

    public int maxSubarraySumCircular(int[] nums) {
        int globalMax = nums[0];
        int globalMin = nums[0];
        int curMax = 0;
        int curMin = 0;
        int total = 0;

        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            curMin = Math.min(curMin + num, num);
            total += num;
            globalMax = Math.max(curMax, globalMax);
            globalMin = Math.min(curMin, globalMin);
        }
        return globalMax > 0 ? Math.max(globalMax, total - globalMin) : globalMax;
    }

}
