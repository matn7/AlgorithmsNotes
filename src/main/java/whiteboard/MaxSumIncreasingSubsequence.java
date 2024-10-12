package whiteboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxSumIncreasingSubsequence {

    public static void main(String[] args) {
        int[] array = {10, 70, 20, 30, 50, 11, 30};
//        int[] array = {1, 2, 3, 4, 5};

        maxSumIncreasingSubsequence(array);
    }

    // O(n^2) time | O(n) space
    // #2: 02/07/2022
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        // Write your code here.
        List<List<Integer>> result = new ArrayList<>();
        int maxIdx = 0;
        int currMax = array[0];
        int[] sums = new int[array.length];
        Integer[] sequence = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            sums[i] = array[i];
            sequence[i] = null;
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                int current = array[i];
                if (current > array[j]) {
                    if (current + sums[j] >= sums[i]) {
                        sums[i] = sums[j] + array[i];
                        sequence[i] = j;
                    }
                }
            }
            if (sums[i] >= currMax) {
                currMax = sums[i];
                maxIdx = i;
            }
        }

        List<Integer> seqRes = new ArrayList<>();
        buildSequence(array, sequence, maxIdx, seqRes);

        Collections.reverse(seqRes);

        result.add(Arrays.asList(currMax));
        result.add(seqRes);

        return result;
    }

    private static void buildSequence(int[] array, Integer[] sequence, int maxIdx, List<Integer> seqRes) {
        Integer seqIdx = maxIdx;
        while (seqIdx != null) {
            seqRes.add(array[seqIdx]);
            seqIdx = sequence[seqIdx];
        }
    }

}
