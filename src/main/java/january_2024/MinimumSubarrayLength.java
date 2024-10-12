package january_2024;

public class MinimumSubarrayLength {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int k = 7;

        int result = minSubArray(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int minSubArray(int[] nums, int k) {
        int sum = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        int minLength = Integer.MAX_VALUE;

        while (rightIndex < nums.length) {
            sum += nums[rightIndex];

            while (sum >= k) {
                minLength = Math.min(minLength, rightIndex - leftIndex + 1);
                sum -= nums[leftIndex];
                leftIndex++;
            }
            rightIndex++;
        }

        if (minLength == Integer.MAX_VALUE) {
            return 0;
        }

        return minLength;
    }

}
