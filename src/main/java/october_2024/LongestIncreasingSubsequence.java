package october_2024;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        LongestIncreasingSubsequence longest = new LongestIncreasingSubsequence();
        int result = longest.lengthOfLIS(nums);
        System.out.println(result);
    }

    // O(n^2) time | O(n) space
    public int lengthOfLIS(int[] nums) {
        int max = 1;

        int[] sequence = new int[nums.length];
        Arrays.fill(sequence, 1);

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int other = nums[j];
                if (curr < other) {
                    sequence[j] = Math.max(sequence[j], sequence[i] + 1);
                    max = Math.max(max, sequence[j]);
                }
            }
        }

        return max;
    }

}
