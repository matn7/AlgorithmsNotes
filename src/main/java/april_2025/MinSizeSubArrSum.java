package april_2025;

public class MinSizeSubArrSum {

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        MinSizeSubArrSum minSizeSubArrSum = new MinSizeSubArrSum();
        int result = minSizeSubArrSum.minSubArrayLen(target, nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int minSubArrayLen(int target, int[] nums) {
        int L = 0;
        int R = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while (R < nums.length) {
            sum += nums[R];
            while (sum >= target) {
                len = Math.min(len, R - L + 1);
                sum -= nums[L];
                L++;
            }
            R++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

}
