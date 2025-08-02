package july_2025;

public class MinSizeSubarrSum {

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};

        MinSizeSubarrSum minSizeSubarrSum = new MinSizeSubarrSum();
        int result = minSizeSubarrSum.minSubArrayLen(target, nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int minSubArrayLen(int target, int[] nums) {
        int L = 0;
        int R = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        while (R < nums.length) {
            while (R < nums.length && sum < target) {
                sum += nums[R];
                R++;
            }
            if (sum < target) {
                break;
            }
            while (L <= R && sum >= target) {
                sum -= nums[L];
                L++;
            }
            result = Math.min(result, R - L + 1);
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
