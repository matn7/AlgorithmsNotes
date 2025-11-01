package october_2025;

import java.util.Arrays;

public class MinumumSizeSubarraySum {

    public static void main(String[] args) {
//        int target = 7;
//        int[] nums = {2,3,1,2,4,3};

        int target = 4;
        int[] nums = {1,4,4};

        MinumumSizeSubarraySum minumumSizeSubarraySum = new MinumumSizeSubarraySum();
        int result = minumumSizeSubarraySum.minSubArrayLen(target, nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int minSubArrayLen(int target, int[] nums) {
        int L = 0;
        int R = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while (R < nums.length) {
            while (L <= R && sum >= target) {
                minLen = Math.min(minLen, R - L);
                sum -= nums[L];
                L++;
            }
            sum += nums[R];
            R++;
        }
        while (L <= R && sum >= target) {
            minLen = Math.min(minLen, R - L);
            sum -= nums[L];
            L++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

}
