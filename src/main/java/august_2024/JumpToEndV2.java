package august_2024;

import java.util.Arrays;

public class JumpToEndV2 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 1, 1, 9, 3, 4};

        int result = jumpToEnd(nums);
        System.out.println();
    }

    public static int jumpToEnd(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] jumps = new int[nums.length];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            int currReach = i + nums[i];
            for (int j = i + 1; j <= currReach; j++) {
                if (j + i < nums.length) {
                    jumps[i + j] = Math.min(jumps[i] + 1, jumps[i + j]);
                } else {
                    break;
                }
            }
        }

        return jumps[jumps.length - 1];
    }

}
