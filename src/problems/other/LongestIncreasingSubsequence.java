package problems.other;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3};

        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        longestIncreasingSubsequence.longest_increasing_subsequence(arr);
    }

    // O(n^2) time | O(n) space
    public int longest_increasing_subsequence(int[] arr) {
        int[] cache = new int[arr.length];
        Arrays.fill(cache, 1);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    cache[i] = Math.max(cache[i], cache[j] + 1);
                    max = Math.max(max, cache[i]);
                }
            }
        }
        return max;
    }

}
