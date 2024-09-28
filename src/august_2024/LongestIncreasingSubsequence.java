package august_2024;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = {5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35};

        longestSequence(arr);
    }

    // O(n^2) time | O(n) space
    public static List<Integer> longestSequence(int[] arr) {

        //                         j
        //             i
        //            [5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35]
        // sequence = [n, 0,   n,  0,  0, n, n,  0, n, 0,  0]
        //             0  1    2   3   4  5  6   7  8  9   10
        Integer[] sequence = new Integer[arr.length];
        int[] counts = new int[arr.length];
        int maxValue = Integer.MIN_VALUE;
        int maxIdx = 0;

        for (int i = 0; i < arr.length; i++) {
            int currNum = arr[i];  // 5
            for (int j = i + 1; j < arr.length; j++) {
                int otherNum = arr[j]; // 7
                if (otherNum > currNum) {
                    sequence[j] = i;
                    counts[j] = Math.max(counts[j], counts[i] + 1);
                    if (counts[j] > maxValue) {
                        maxValue = counts[j];
                        maxIdx = j;
                    }
                }
            }
        }

        List<Integer> result = buildSequence(arr, sequence, maxIdx);

        return result;
    }

    private static List<Integer> buildSequence(int[] arr, Integer[] seqence, int maxIdx) {
        List<Integer> result = new ArrayList<>();
        int currIdx = maxIdx;
        while (seqence[currIdx] != null) {
            result.add(arr[currIdx]);
            currIdx = seqence[currIdx];
            System.out.println();
        }
        result.add(arr[currIdx]);
        Collections.reverse(result);
        return result;
    }

}
