package march_2025;

import september_2024.LongestSubstring;

public class LongestSubarray {

    public static void main(String[] args) {
        int[] nums = {4, 2, 2, 3, 3, 3};
        LongestSubarray subarray = new LongestSubarray();
        int length = subarray.findLength(nums);
        System.out.println(length);
    }

    public int findLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int longest = 1;
        int L = 0;
        for (int R = 1; R < nums.length; R++) {
            if (nums[L] != nums[R]) {
                L = R;
            }
            longest = Math.max(longest, R - L + 1);
        }
        return longest;
    }

}
