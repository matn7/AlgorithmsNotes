package may_2025;

public class MaxSubarraySumCircular {

    public static void main(String[] args) {
        int[] nums = {1, -2, 3, -2};

        MaxSubarraySumCircular maxSubarraySumCircular = new MaxSubarraySumCircular();
        int result = maxSubarraySumCircular.maxSubarraySumCircular(nums);
        System.out.println(result);
    }

    public int maxSubarraySumCircular(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int curMax = 0;
        int curMin = 0;

        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            curMin = Math.min(curMin + num, num);
            max = Math.max(max, curMax);
            min = Math.min(min, curMin);
            sum += num;
        }
        return max > 0 ? Math.max(max, sum - min) : max;
    }

}
