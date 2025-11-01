package october_2025;

import java.util.Arrays;

public class HouseRobberII {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};

        HouseRobberII houseRobberII = new HouseRobberII();
        int result = houseRobberII.rob(nums);
        System.out.println(result);

    }

    // O(n) time | O(1) space
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(helper(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                helper(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int helper(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);
        int c = 0;

        for (int i = 2; i < nums.length; i++) {
            c = Math.max(b, nums[i] + a);
            a = b;
            b = c;
        }
        return b;
    }


}
