package december_2025;

public class LongestSubarray2 {

    public static void main(String[] args) {
        //int[] nums = {1, 1, 0, 1};
        int[] nums = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        LongestSubarray2 longestSubarray2 = new LongestSubarray2();
        int result = longestSubarray2.longestSubarray(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int longestSubarray(int[] nums) {
        int L = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int R = 0; R < nums.length; R++) {
            if (nums[R] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[L] == 0) {
                    zeroCount--;
                }
                L++;
            }
            maxLen = Math.max(maxLen, R - L);
            System.out.println();
        }
        return maxLen;

    }

}
