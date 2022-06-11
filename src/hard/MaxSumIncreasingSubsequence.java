package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxSumIncreasingSubsequence {

    public static void main(String[] args) {
        int[] array = {8, 12, 2, 3, 15, 5, 7};

        maxSumIncreasingSubsequence(array);
    }

    // O(n^2) time | O(n) space
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        // Write your code here.
        List<Integer> sums = new ArrayList<>();
        for (Integer element : array) {
            sums.add(element);
        }
        List<Integer> sequences = new ArrayList<>();
        for (Integer element : array) {
            sequences.add(null);
        }
        int maxSumIdx = 0;

        for (int i = 0; i < array.length; i++) { // i = 1
            int currentNum = array[i]; // 15
            for (int j = 0; j < i; j++) {
                int otherNum = array[j]; // 8
                if (otherNum < currentNum && sums.get(j) + currentNum >= sums.get(i)) {
                    sums.remove(i);
                    sums.add(i, sums.get(j) + currentNum); // 15 + 8
                    sequences.remove(i);
                    sequences.add(i, j);
                }
            }
            if (sums.get(i) >= sums.get(maxSumIdx)) {
                maxSumIdx = i;
            }
        }

        List<Integer> integers = buildSequence(array, sequences, maxSumIdx);
        List<Integer> reversed = new ArrayList<>();
        int counter = integers.size() - 1;
        for (Integer element : integers) {
            reversed.add(integers.get(counter));
            counter--;
        }

        int finalMaxSumIdx = maxSumIdx;
        return new ArrayList<List<Integer>>() {
            {
                add(List.of(sums.get(finalMaxSumIdx))); // Example max sum
                add(reversed); // Example max sequence
            }
        };
    }

    private static List<Integer> buildSequence(int[] array, List<Integer> sequences, Integer currentIdx) {
        List<Integer> sequence = new ArrayList<>();
        while (currentIdx != null) {
            sequence.add(array[currentIdx]);
            currentIdx = sequences.get(currentIdx);
        }
        return sequence;
    }

}
