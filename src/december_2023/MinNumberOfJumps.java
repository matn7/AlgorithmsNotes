package december_2023;

import java.util.Arrays;

public class MinNumberOfJumps {

    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 1, 1, 9, 3, 4};
    }

    // O(n) time | O(1) space
    public static int minJumps(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int jumps = 0;
        int maxReach = nums[0];
        int steps = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            steps -= 1;
            if (steps == 0) {
                jumps++;
                steps = maxReach - i;
            }
        }

        return jumps + 1;
    }

    // O(n^2) time | O(n) space
    public static int minJumpsV2(int[] nums) {
        int[] hops = new int[nums.length];
        Arrays.fill(hops, Integer.MAX_VALUE);
        hops[0] = 0;

        //         0  1  2  3  4  5  6  7
        // -------------------------------
        // nums = [3, 2, 5, 1, 1, 9, 3, 4]
        // hops = [0, 1, 1, 1, m, m, m, m]
        //            i
        //                  j
        // n = 2
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            for (int j = i; j < n + 1; j++) {
                if (i + j < hops.length) {
                    hops[i + j] = Math.min(hops[i + j], hops[i] + 1);
                } else {
                    break;
                }
            }
        }
        return hops[hops.length - 1];
    }
}
