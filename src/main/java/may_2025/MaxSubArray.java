package may_2025;

public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {-2, 1};
        MaxSubArray maxSubArray = new MaxSubArray();
        int result = maxSubArray.maxSubArray(nums);
        System.out.println(result);
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int curMax;

        for (int num : nums) {
            sum += num;
            curMax = Math.max(sum, num);
            if (sum < 0) {
                sum = 0;
            }
            max = Math.max(curMax, max);
        }

        return max;
    }

}
