package august_2024;

public class MinSubArray {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int k = 7;

        int result = minSubArray(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int minSubArray(int[] nums, int k) {
        // [2, 3, 1, 2, 4, 3]
        //  *
        int start = 0;
        int end = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end];
            while (start < end && sum > k) {
                sum -= nums[start];
                start++;
            }
            if (sum == k) {
                int currLen = end - start + 1;
                if (currLen < minLength) {
                    minLength = currLen;
                }
            }
            end++;
        }

        if (minLength == Integer.MAX_VALUE) {
            return -1;
        }
        return minLength;
    }

}
