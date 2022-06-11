package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxSumIncreasingSubsequenceREPEAT {

    public static void main(String[] args) {
        int[] array = {8, 12, 2, 3, 15, 5, 7};

        List<List<Integer>> lists = maxSumIncreasingSubsequence(array);

        System.out.println(lists);
    }

    // O(n^2) time | O(n) space
    // OK - repeated 25/01/2022
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        // Write your code here.
        // [ , , , , , , ]
        List<Integer> sequences = new ArrayList<>();
        // [ , , , , , , ]
        List<Integer> sums = new ArrayList<>();
        for (int element : array) {
            sums.add(element);
            sequences.add(null);
        }
        // arr [ 8, 12, 2, 3, 15, 5, 7]
        // seq [ null, null, null, null, null, null, null]
        // sum [ 8, 12, 2, 3, 15, 5, 7]

        int maxSumIdx = 0;
        for (int i = 0; i < array.length; i++) { // i: 6
            int currentNum = array[i]; // 8 | 12 | 2 | 3 | 15 | 5 | 7
            for (int j = 0; j < i; j++) { // j: 5
                int otherNum = array[j]; // 8 | 12 | 2 | 3 | 15 | 5
                if (currentNum > otherNum && sums.get(j) + currentNum >= sums.get(i)) {
                    // [ 8, 20, 2, 5, 35, 10, 17]
                    sums.set(i, sums.get(j) + currentNum);
                    // [ null, 0, null, 2, 1, 3, 5]
                    sequences.set(i, j);
                }
            }
            if (sums.get(i) >= sums.get(maxSumIdx)) {
                maxSumIdx = i; // 0, 1
            }
        }

        // sums [8, 20, 2, 5, 35, 10, 17]
        // seq  [n,  0, n, 2,  1,  3,  5]

        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(sums.get(maxSumIdx)));
        result.add(buildSequence(array, sequences, maxSumIdx));

        return result; // [35, [8, 12, 15]]
    }

    private static List<Integer>  buildSequence(int[] array, List<Integer> sequences, Integer currentIdx) {
        // [8, 12, 2, 3, 15, 5, 7]
        // seq  [null,  0, null, 2,  1,  3,  5]
        // currentIdx = 4
        List<Integer> sequence = new ArrayList<>();
        while (currentIdx != null) {
            sequence.add(array[currentIdx]); // [15, 12, 8]
            currentIdx = sequences.get(currentIdx); // 1, 0
        }
        Collections.reverse(sequence);
        return sequence; // [8, 12, 15]
    }

}
