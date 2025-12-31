package december_2025;

public class NeighborhoodBurglary {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};

        NeighborhoodBurglary neighborhoodBurglary = new NeighborhoodBurglary();
        int result = neighborhoodBurglary.rob(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // int[] dp = new int[nums.length];
        // dp[0] = nums[0];
        int a = nums[0];
        // dp[1] = Math.max(nums[0], nums[1]);
        int b = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
//            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
            int temp = Math.max(b, nums[i] + a);
            a = b;
            b = temp;
        }
        // return dp[dp.length - 1];
        return b;
    }

}
