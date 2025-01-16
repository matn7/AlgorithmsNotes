package december_2024;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        LongestIncreasingSubsequence subsequence = new LongestIncreasingSubsequence();
        int result = subsequence.lengthOfLIS(nums);
        System.out.println(result);
    }

    public int lengthOfLIS(int[] nums) {

        int[] sequence = new int[nums.length];
        Arrays.fill(sequence, 1);
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            for (int j = i; j < nums.length; j++) {
                int other = nums[j];
                if (curr < other) {
                    sequence[j] = Math.max(sequence[i] + 1, sequence[j]);
                }
            }
            max = Math.max(max, sequence[i]);
        }

        return max;
    }

}
