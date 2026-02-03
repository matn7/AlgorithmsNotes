package january_2026;

public class LongestSubarray {

    public static void main(String[] args) {
        int[] nums = {0,1,1,1,0,1,1,0,1};

        LongestSubarray longestSubarray = new LongestSubarray();
        int result = longestSubarray.longestSubarray(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int longestSubarray(int[] nums) {
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int used = 0;

        while (r < nums.length) {
            if (nums[r] == 0) {
                used++;
            }
            while (used > 1) {
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
