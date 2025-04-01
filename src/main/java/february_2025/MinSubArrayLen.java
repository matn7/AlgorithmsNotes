package february_2025;

public class MinSubArrayLen {

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        int result = minSubArrayLen.minSubArrayLen(target, nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int minSubArrayLen(int target, int[] nums) {
        int minWindow = Integer.MAX_VALUE;
        int L = 0;
        int R = 0;
        int curSum = 0;

        while (R < nums.length) {
            curSum += nums[R];
            while (curSum >= target) {
                minWindow = Math.min(minWindow, R - L + 1);
                curSum -= nums[L];
                L++;
            }
            R++;
        }
        return minWindow == Integer.MAX_VALUE ? 0 : minWindow;
    }

}
