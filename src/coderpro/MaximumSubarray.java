package coderpro;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int result = maximumSubarray.maxSubArray(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int n : nums) {
            sum += n;
            if (sum < 0) {
                sum = 0;
            } else {
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

}
