package october_2024;

import java.util.Arrays;

public class JumpGameII {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {1, 2};
//        int[] nums = {1, 1, 1, 1};

        JumpGameII jumpGameII = new JumpGameII();
        int jump = jumpGameII.jump(nums);
        System.out.println(jump);
    }

    // leetcode 45

    // O(n) time | O(1) space
    public int jump(int[] nums) {
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
                jumps += 1;
                steps = maxReach - i;
            }
        }
        return jumps + 1;
    }

    // O(n^2) time | O(n) space
    public static int jump2(int[] nums) {
        if (nums.length <= 1) {
            return 0; // No jumps needed if there is only one or no element
        }

        int[] hops = new int[nums.length];
        Arrays.fill(hops, Integer.MAX_VALUE);
        hops[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                hops[i + j] = Math.min(hops[i + j], hops[i] + 1);
            }
        }

        // Return -1 if unreachable
        return hops[hops.length - 1] == Integer.MAX_VALUE ? -1 : hops[hops.length - 1];
    }

    // O(n) time | O(1) space
    public int jump3(int[] nums) {
        int res = 0;
        int l = 0;
        int r = 0;
        // [2, 3, 1, 1, 4]
        while (r < nums.length - 1) {
            int farthest = 0;
            for (int i = l; i < r + 1; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            res++;
        }

        return res;
    }

}
