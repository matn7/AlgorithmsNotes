package december_2025;

public class MinSizeSubarraySum {

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};

        MinSizeSubarraySum minSizeSubarraySum = new MinSizeSubarraySum();
        int result = minSizeSubarraySum.minSubArrayLen(target, nums);
        System.out.println(result);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;

        int L = 0;
        int R = 0;
        int sum = 0;

        while (R < nums.length) {
            while (R < nums.length && sum < target) {
                sum += nums[R];
                R++;
            }
            while (L < R && sum >= target) {
                minLen = Math.min(minLen, R - L);
                sum -= nums[L];
                L++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

}
