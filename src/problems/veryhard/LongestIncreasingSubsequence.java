package problems.veryhard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] array = {5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35};

        longestIncreasingSubsequence(array);
    }

    // O(nlog(n)) time | O(n) space
    public static List<Integer> longestIncreasingSubsequence(int[] array) {
        List<Integer> sequences = new ArrayList<>();
        List<Integer> indices = new ArrayList<>();
        indices.add(null);
        //  0  1    2   3   4  5  6   7  8  9  10
        //                     i
        // [5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35]
        for (int element : array) {
            sequences.add(null);
            indices.add(null);
        }
        // sequences = [null, 0, null, 1, 1, 2, 5, 6, 6, 8, 9]
        // indices   = [null, 2, 5, 6, 8, 9, 10, null, null, null, null]
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            int num = array[i]; // 2
            // rec(1,5,[],[],2)
            int newLength = binarySearch(1, length, indices, array, num); // 1
            sequences.set(i, indices.get(newLength - 1));
            indices.set(newLength, i);
            length = Math.max(length, newLength); // max(2,3) = 3
        }
        return buildSequence(array, sequences, indices.get(length));
    }
    //                     *
    // [5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35]
    // rec(1,5,[],[],2)
    private static int binarySearch(int startIdx, int endIdx, List<Integer> indices, int[] array, int num) {
        if (startIdx > endIdx) {
            return startIdx;
        }
        int middleIdx = (startIdx + endIdx) / 2; // 1
        if (array[indices.get(middleIdx)] < num) { // 5 < 2
            startIdx = middleIdx + 1;
        } else {
            endIdx = middleIdx - 1;
        }
        // rec(1,0,[],[],2)
        return binarySearch(startIdx, endIdx, indices, array, num);
    }

    //                                   *
    // sequences = [null, 0, null, 1, 1, 2, 5, 6, 6, 8, 9]
    //                       *
    // indices   = [null, 2, 5, 6, 8, 9, 10, null, null, null, null]
    // rec([5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35], [], )
    //      0  1    2   3   4  5  6   7  8  9  10
    private static List<Integer> buildSequence(int[] array, List<Integer> sequences, Integer currentIdx) {
        List<Integer> sequence = new ArrayList<>();
        while (currentIdx != null) {
            sequence.add(array[currentIdx]); // [35, 6, 5, 3, 2, -24]
            currentIdx = sequences.get(currentIdx);
        }
        Collections.reverse(sequence);
        return sequence; // [-24, 2, 3, 5, 6, 35]
    }

    // OK - repeated 24/02/2022
    // O(n^2) time | O(n) space
    public static List<Integer> longestIncreasingSubsequence2(int[] array) {
        // Write your code here.
        List<Integer> sequences = new ArrayList<>();
        //                                              i
        // array     = [5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35]
        // sequences = [n, 0,   n,  1,  1, 2, 5,  6, 6, 8,  9]
        // lengths   = [1, 2,   1,  3,  3, 2, 3,  4, 4, 5,  6]
        List<Integer> lengths = new ArrayList<>();
        Integer maxLengthIdx = 0;
        for (int element : array) {
            sequences.add(null);
            lengths.add(1);
        }
        //                                              i
        // array     = [5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35]
        //                                 j
        for (int i = 0; i < array.length; i++) {
            int currentNum = array[i]; // 6
            for (int j = 0; j < i; j++) {
                int otherNum = array[j]; // 3
                if (otherNum < currentNum && lengths.get(j) + 1 >= lengths.get(i)) { // 5 < 10 && 2 >= 1
                    lengths.set(i, lengths.get(j) + 1);
                    sequences.set(i, j);
                }
            }
            if (lengths.get(i) >= lengths.get(maxLengthIdx)) {
                maxLengthIdx = i; // 4
            }
        }
        return buildSequence2(array, sequences, maxLengthIdx);
    }

    private static List<Integer> buildSequence2(int[] array, List<Integer> sequences, Integer currentIdx) {
        List<Integer> sequence = new ArrayList<>();
        while (currentIdx != null) {
            sequence.add(array[currentIdx]);
            currentIdx = sequences.get(currentIdx);
        }
        Collections.reverse(sequence);
        return sequence;
    }

}
