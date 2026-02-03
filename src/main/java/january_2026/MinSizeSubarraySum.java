package january_2026;

public class MinSizeSubarraySum {

    public static void main(String[] args) {
//        int target = 7;
//        int[] nums = {2,3,1,2,4,3};

        int target = 4;
        int[] nums = {1,4,4};

        MinSizeSubarraySum minSizeSubarraySum = new MinSizeSubarraySum();
        int result = minSizeSubarraySum.minSubArrayLen(target, nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int sum = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum >= target) {
                minLen = Math.min(minLen, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

}
