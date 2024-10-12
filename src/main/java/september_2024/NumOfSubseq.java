package september_2024;

import java.util.Arrays;

public class NumOfSubseq {

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;

        NumOfSubseq numOfSubseq = new NumOfSubseq();
        int result = numOfSubseq.numSubseq(nums, target);
        System.out.println(result);
    }

    // leetcode 1498
    public int numSubseq(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        int mod = (int) Math.pow(10, 9) + 7;
        int r = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            int left = nums[i];
            while (r > 0 && left + nums[r] > target && i <= r) {
                r--;
            }
            if (i <= r) {
                res += Math.pow(2, r - i);
                res %= mod;
            }
        }

        return res;
    }

}
