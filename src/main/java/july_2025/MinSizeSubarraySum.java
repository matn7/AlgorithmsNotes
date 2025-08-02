package july_2025;

public class MinSizeSubarraySum {

    public static void main(String[] args) {
//        int target = 7;
//        int[] nums = {2,3,1,2,4,3};

//        int target = 4;
//        int[] nums = {1,4,4};

        int target = 213;
        int[] nums = {12,28,83,4,25,26,25,2,25,25,25,12};

//        int target = 11;
//        int[] nums = {1,1,1,1,1,1,1,1};

        MinSizeSubarraySum minSizeSubarraySum = new MinSizeSubarraySum();
        int result = minSizeSubarraySum.minSubArrayLen(target, nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int minSubArrayLen(int target, int[] nums) {
        int L = 0;
        int R = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;

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
            res = Math.min(res, R - L + 1);
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
