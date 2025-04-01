package march_2025;

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {2, 9, 8, 3, 6};
    }

    // O(n) time | O(n) space
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);

        int a = nums[0];
        int b = nums[1];
        int c = Math.max(a, b);

        for (int i = 2; i < nums.length; i++) {
//            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            c = Math.max(a + nums[i], b);
            a = b;
            b = c;
        }
        return c;
    }

}
