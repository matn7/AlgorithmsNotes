package june_2025;

public class HouseRobberII2 {

    public static void main(String[] args) {
//        int[] nums = {2, 3, 2};
        int[] nums = {1,2};

        HouseRobberII2 houseRobberII2 = new HouseRobberII2();
        int result = houseRobberII2.rob(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int rob(int[] nums) {
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robHelper(nums, 0, nums.length - 1), robHelper(nums, 1, nums.length));
    }

    private int robHelper(int[] nums, int start, int end) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i < end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return start == 0 ? dp[dp.length - 2] : dp[dp.length - 1];
    }

}
