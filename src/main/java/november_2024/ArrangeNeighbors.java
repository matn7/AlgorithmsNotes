package november_2024;

import java.util.Arrays;

public class ArrangeNeighbors {

    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[nums.length];

        int idx = 0;
        int l = 0;
        int r = nums.length - 1;
        while (idx < nums.length) {
            res[idx] = nums[l];
            l++;
            idx++;

            if (l <= r) {
                res[idx] = nums[r];
                r--;
                idx++;
            }
        }
        return res;
    }

}
