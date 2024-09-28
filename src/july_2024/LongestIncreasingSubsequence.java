package july_2024;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = {0, 8, 4, 12, 2, 10, 6, 13, 1, 9, 5, 13, 3};

        int result = longestIncreasingSubsequence(arr);
        System.out.println(result);
    }

    // O(n^2) time | O(n) space
    public static int longestIncreasingSubsequence(int[] arr) {
        int maxSeq = Integer.MIN_VALUE;
        int[] sequence = new int[arr.length];
        Arrays.fill(sequence, 1);

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            for (int j = i; j < arr.length; j++) {
                int other = arr[j];
                if (current < other) {
                    sequence[j] = Math.max(sequence[j], sequence[i] + 1);
                    maxSeq = Math.max(maxSeq, sequence[j]);
                }
            }
        }

        return maxSeq;
    }

}
