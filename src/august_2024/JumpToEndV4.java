package august_2024;

import java.util.Arrays;

public class JumpToEndV4 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 1, 1, 9, 3, 4};

        System.out.println(jumpToEnd(nums));

        System.out.println(jumpToEndV2(nums));
    }

    public static int jumpToEndV2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int range = nums[0];
        int steps = range;
        int jumps = 0;

        for (int i = 0; i < nums.length; i++) {
            range = Math.max(range, i + nums[i]);
            steps--;
            if (steps == 0) {
                steps = range - i;
                jumps++;
            }
        }
        return jumps;

    }

    // O(n^2) time | O(n) space
    public static int jumpToEnd(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, Integer.MAX_VALUE);

        result[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            int range = nums[i];
            for (int j = i; j <= range; j++) {
                if (i + j < nums.length) {
                    result[i + j] = Math.min(result[i + j], result[i] + 1);
                } else {
                    break;
                }
            }
        }

        return result[result.length - 1];
    }

}
