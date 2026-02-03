package january_2026;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};

        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        int result = longestIncreasingSubsequence.lengthOfLIS(nums);
        System.out.println(result);
    }

    // O(n^2) time | O(n) space
    public int lengthOfLIS(int[] nums) {
        int[] sequence = new int[nums.length];
        Arrays.fill(sequence, 1);
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    sequence[j] = Math.max(sequence[j], 1 + sequence[i]);
                    max = Math.max(max, sequence[j]);
                }
            }
        }
        return max;
    }


}
