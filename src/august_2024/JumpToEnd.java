package august_2024;

import java.util.Arrays;

public class JumpToEnd {

    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 1, 1, 9, 3, 4};

        int result = jumpToEnd(nums);
        System.out.println(result);

        System.out.println(jumpToEndV2(nums));
    }

    // O(n^2) time | O(n) space
    public static int jumpToEnd(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] distances = new int[nums.length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            for (int j = i; j < n + 1; j++) {
                if (i + j < distances.length) {
                    distances[i + j] = Math.min(distances[i + j], distances[i] + 1);
                } else {
                    break;
                }
            }
        }
        return distances[distances.length - 1];
    }

    public static int jumpToEndV2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int jumps = 0;
        int steps = nums[0];
        int maxReach = nums[0];

        // [3, 2, 5, 1, 1, 9, 3, 4]
        //  i

        for (int i = 0; i < nums.length; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            steps--;
            if (steps == 0) {
                jumps++;
                steps = maxReach - i;
            }
        }

        return jumps;
    }
























}
