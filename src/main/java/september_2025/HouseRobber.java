package september_2025;

public class HouseRobber {

    public static void main(String[] args) {
//        int[] nums = {1,2,3,1};

        int[] nums = {2,7,9,3,1};
        HouseRobber houseRobber = new HouseRobber();
        int result = houseRobber.rob(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0]; // a = dp[0]
        dp[1] = Math.max(nums[0], nums[1]); // b = max(a, dp[1])
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]); // c = max(b, nums[i] + a)
        }
        return dp[dp.length - 1];
    }

}
