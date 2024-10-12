package november_2023;

import java.util.Arrays;

public class JumpToEnd {

    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 1, 1, 9, 3, 4};

        int result = jumpToEnd(nums);
        System.out.println(result);
        System.out.println(minNumberOfJumps(nums));
    }

    // O(n^2) time | O(n) space
    public static int jumpToEnd(int[] nums) {
        int[] hops = new int[nums.length];
        Arrays.fill(hops, Integer.MAX_VALUE);
        hops[0] = 0;

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

    // O(n) time | O(1) space
    public static int minNumberOfJumps(int[] array) {
        if (array.length == 1) {
            return 0;
        }
        int jumps = 0;
        int maxReach = array[0];
        int steps = array[0];
        for (int i = 1; i < array.length - 1; i++) {
            maxReach = Math.max(maxReach, i + array[i]);
            steps -= 1;
            if (steps == 0) {
                jumps += 1;
                steps = maxReach - i;
            }
        }
        return jumps + 1;
    }

}
