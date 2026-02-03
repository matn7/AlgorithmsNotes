package january_2026;

public class MaxConsecutiteOnes {

    // O(n) time | O(1) space
    public int longestOnes(int[] nums, int k) {
        int used = 0;
        int l = 0;
        int r = 0;
        int maxLen = 0;

        while (r < nums.length) {
            if (nums[r] == 0) {
                used++;
            }

            while (used > k) {
                if (nums[l] == 0) {
                    used--;
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

}
