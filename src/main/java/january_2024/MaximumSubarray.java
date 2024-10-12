package january_2024;

public class MaximumSubarray {

    public static void main(String[] args) {
        // int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5};
        int[] nums = {-1, -4, 3, 8, 1};

        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray2(nums));

    }

    // O(n) time | O(1) space
    public static int maxSubArray(int[] nums) {
        //   0  1   2  3   4  5  6   7  8
        // [-2, 1, -3, 4, -1, 2, 1, -5, 4]
        //      l
        //             r
        int max = Integer.MIN_VALUE; // -1
        int leftIdx = 0;
        int rightIdx = 0;
        int sum = 0;

        while (rightIdx < nums.length) {
            sum += nums[rightIdx]; // -2
            if (sum > max) {
                max = sum;
            } else {
                sum -= nums[leftIdx];
                leftIdx++;
            }
            rightIdx++;
        }

        return max;

    }

    // O(n) time | O(1) space
    public static int maxSubArray2(int[] nums) {
        int maxSum = 0;
        int sum = 0;
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
