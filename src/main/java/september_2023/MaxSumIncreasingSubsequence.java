package september_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxSumIncreasingSubsequence {

    public static void main(String[] args) {
//        int[] array = {10, 70, 20, 30, 50, 11, 30};
        int[] array = {8, 12, 2, 3, 15, 5, 7};

        List<List<Integer>> result = maxSumIncreasingSubsequence(array);
        System.out.println(result);
    }

    // O(n^2) time | O(n) space
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        // Write your code here.

        //   0   1   2   3   4   5   6
        // [10, 70, 20, 30, 50, 11, 30] array
        //                   i
        //               j
        // [ n,  0,  0,  2,  3,  n,  n] sequence
        // [10, 80, 30, 60,110, 11, 30] sums

        // maxSum = 110
        // startIdx = 4
        List<List<Integer>> result = new ArrayList<>();
        int[] sums = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            sums[i] = array[i];
        }
        int startIdx = 0;
        Integer[] sequence = new Integer[array.length];
        Arrays.fill(sequence, null);
        for (int i = 1; i < array.length; i++) {
            int currNum = array[i];
            for (int j = 0; j < i; j++) {
                int otherNum = array[j];
                if (currNum > otherNum && sums[j] + currNum > sums[i]) {
                    sequence[i] = j;
                    sums[i] = currNum + sums[j]; // max(80, 110)
                }
            }
            if (sums[i] >= sums[startIdx]) {
                startIdx = i;
            }
        }
        result.add(Arrays.asList(sums[startIdx]));
        List<Integer> sequenceResult = buildSequence(sequence, startIdx, array);
        result.add(sequenceResult);
        return result;
    }

    private static List<Integer> buildSequence(Integer[] sequence, int startIdx, int[] array) {
        List<Integer> result = new ArrayList<>();
        Integer currentIdx = startIdx;
        while (currentIdx != null) {
            Integer currValue = array[currentIdx];
            result.add(currValue);
            currentIdx = sequence[currentIdx];
        }
        Collections.reverse(result);
        return result;
    }

}
