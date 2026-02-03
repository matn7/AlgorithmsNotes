package january_2026;

public class MaximumSizeSubarraySum {

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};

        MaximumSizeSubarraySum maximumSizeSubarraySum = new MaximumSizeSubarraySum();
        int result = maximumSizeSubarraySum.minSubArrayLen(target, nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int l = 0;
        int result = Integer.MAX_VALUE;

        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                result = Math.min(result, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }


}
