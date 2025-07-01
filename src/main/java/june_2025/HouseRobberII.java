package june_2025;

public class HouseRobberII {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};

        HouseRobberII houseRobberII = new HouseRobberII();
        int result = houseRobberII.rob(nums);
        System.out.println(result);
    }

    public int rob(int[] nums) {
        return Math.max(helper(nums, 0), helper(nums, 1));
    }

    private int helper(int[] nums, int s) {
        int[] dp = new int[nums.length - 1];
        dp[0] = nums[s];
        dp[1] = Math.max(nums[s], nums[s + 1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i + s] + dp[i - 2]);
        }
        return dp[dp.length - 1];
    }


}
