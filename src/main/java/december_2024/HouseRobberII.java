package december_2024;

public class HouseRobberII {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};

        HouseRobberII houseRobberII = new HouseRobberII();
        int rob = houseRobberII.rob(nums);
        System.out.println(rob);
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(helper(nums, 0), helper(nums, 1));
    }

    private int helper(int[] nums, int idx) {
        int a = 0;
        int b = 0;
        int num;
        for (int i = idx; i < nums.length - 1 + idx; i++) {
            num = Math.max(nums[i] + a, b);
            a = b;
            b = num;
        }
        return b;
    }

}
