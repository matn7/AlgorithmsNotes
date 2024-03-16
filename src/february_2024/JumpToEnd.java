package february_2024;

import java.util.Arrays;

public class JumpToEnd {

    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 1, 1, 9, 3, 4};

        int result = jumpToEnd(nums);
        System.out.println(result);

        int result2 = jumpToEnd2(nums);
        System.out.println(result2);
    }

    public static int jumpToEnd2(int[] nums) {
        int maxReach = nums[0];
        int steps = nums[0];
        int jump = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            steps--;
            if (steps == 0) {
                jump++;
                steps = maxReach - i;
            }
        }
        return jump + 1;
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

}
