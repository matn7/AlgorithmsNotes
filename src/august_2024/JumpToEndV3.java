package august_2024;

import java.util.Arrays;

public class JumpToEndV3 {

    public static void main(String[] args) {
        //            0  1  2  3  4  5  6  7
        int[] nums = {3, 2, 5, 1, 1, 9, 3, 4};
    }

    public static int jumpToEnd(int[] nums) {
        int[] hops = new int[nums.length];
        Arrays.fill(hops, Integer.MAX_VALUE);
        hops[0] = 0;
        //         0  1  2  3  4  5  6  7
        //        [3, 2, 5, 1, 1, 9, 3, 4]
        //         i
        //                  j
        //         0  1  2  3  4  5  6  7
        // hops = [0, 1, 1, 1, m, m, m, m]
        //

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i]; // 3
            for (int j = i; j < n + 1; j++) {
                if (i + j < hops.length) { // 0 + 0
                    hops[i + j] = Math.min(hops[i + j], hops[i] + 1);
                } else {
                    break;
                }
            }
        }

        return hops[hops.length - 1];

    }

}
