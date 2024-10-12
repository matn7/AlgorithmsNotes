package october_2023;

public class MinimumSubarrayLength {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4, 3};
        int k = 7;

        minSubarrayLength(nums, k);
    }

    // O(n) time | O(1) space
    public static int minSubarrayLength(int[] nums, int k) {
        int start = 0;
        int end = 0;

        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        while (end < nums.length) {
            sum += nums[end];
            while (sum >= k) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }

        if (minLen == Integer.MAX_VALUE) {
            return 0;
        }

        return minLen;
    }

}
