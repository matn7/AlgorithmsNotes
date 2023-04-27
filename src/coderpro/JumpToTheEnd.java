package coderpro;

import java.util.Arrays;

public class JumpToTheEnd {

    public static void main(String[] args) {
        int[] jumps = {3, 2, 5, 1, 1, 9, 3, 4};

        JumpToTheEnd jumpToTheEnd = new JumpToTheEnd();
        int result = jumpToTheEnd.jumpToEnd(jumps);
        System.out.println(result);
    }

    // O(n^2) time | O(n) space
    public int jumpToEnd(int[] nums) {
        int[] hops = new int[nums.length];
        Arrays.fill(hops, Integer.MAX_VALUE);
        hops[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i]; // n is num of hops
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
