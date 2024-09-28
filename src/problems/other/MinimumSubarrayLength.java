package problems.other;

public class MinimumSubarrayLength {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int k = 7;

        MinimumSubarrayLength minimumSubarrayLength = new MinimumSubarrayLength();
        int result = minimumSubarrayLength.minSubArray(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int minSubArray(int[] nums, int k) {
        int minLength = Integer.MAX_VALUE;
        int leftIdx = 0;
        int rightIdx = 0;
        int sum = 0;

        while (rightIdx < nums.length) {
            sum += nums[rightIdx];
            while (sum >= k) {
                minLength = Math.min(minLength, rightIdx - leftIdx + 1);
                sum -= nums[leftIdx];
                leftIdx++;
            }

            rightIdx++;
        }
        if (minLength == Integer.MAX_VALUE) {
            return 0;
        }
        return minLength;
    }

}
