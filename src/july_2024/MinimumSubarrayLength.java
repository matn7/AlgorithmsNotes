package july_2024;

public class MinimumSubarrayLength {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int result = minSubArray(nums, 7);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int minSubArray(int[] nums, int k) {
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= k) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        if (minLength == Integer.MAX_VALUE) {
            return 0;
        }
        return minLength;
    }

}
