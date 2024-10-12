package problems.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxSumIncreasingSubsequence {

    public static void main(String[] args) {
        int[] array = {8, 12, 2, 3, 15, 5, 7};

        List<List<Integer>> lists = maxSumIncreasingSubsequence(array);

        System.out.println(lists);
    }

    // O(n^2) time | O(n) space
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        // Write your code here.
        List<Integer> sequences = new ArrayList<>();
        List<Integer> sums = new ArrayList<>();
        for (int element : array) {
            sums.add(element);
            sequences.add(null);
        }

        int maxSumIdx = 0;
        for (int i = 0; i < array.length; i++) {
            int currentNum = array[i];
            for (int j = 0; j < i; j++) {
                int otherNum = array[j];
                if (currentNum > otherNum && sums.get(j) + currentNum >= sums.get(i)) {
                    sums.set(i, sums.get(j) + currentNum);
                    sequences.set(i, j);
                }
            }
            if (sums.get(i) >= sums.get(maxSumIdx)) {
                maxSumIdx = i;
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(sums.get(maxSumIdx)));
        result.add(buildSequence(array, sequences, maxSumIdx));

        return result;
    }

    private static List<Integer>  buildSequence(int[] array, List<Integer> sequences, Integer currentIdx) {
        List<Integer> sequence = new ArrayList<>();
        while (currentIdx != null) {
            sequence.add(array[currentIdx]);
            currentIdx = sequences.get(currentIdx);
        }
        Collections.reverse(sequence);
        return sequence;
    }
}
