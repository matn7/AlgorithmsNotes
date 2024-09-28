package september_2024;

import java.util.Arrays;

public class JumpToEnd {

    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 1, 1, 9, 3, 4};

        int result = jumpToEnd(nums);
        System.out.println(result);

        System.out.println(jumpToEndV2(nums));
    }

    // O(nm) time | O(n) space
    public static int jumpToEnd(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] distances = new int[nums.length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            for (int j = i; j <= n; j++) {
                if (i + j < nums.length) {
                    distances[i + j] = Math.min(distances[i + j], distances[i] + 1);
                } else {
                    break;
                }
            }
        }
        return distances[distances.length - 1];
    }

    // O(n) time | O(1) space
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

}
