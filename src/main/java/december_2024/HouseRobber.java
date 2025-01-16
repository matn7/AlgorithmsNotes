package december_2024;

import java.io.FilterOutputStream;

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        HouseRobber houseRobber = new HouseRobber();
        int rob = houseRobber.rob(nums);
        System.out.println(rob);
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);
        int num;
        for (int i = 2; i < nums.length; i++) {
            num = Math.max(nums[i] + a, b);
            a = b;
            b = num;
        }
        return b;
    }

    public int rob2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] maxRobbed = new int[nums.length];
        maxRobbed[0] = nums[0];
        maxRobbed[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            maxRobbed[i] = Math.max(nums[i] + maxRobbed[i - 2], maxRobbed[i - 1]);
        }
        return maxRobbed[maxRobbed.length - 1];
    }

}
