package veryhard;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] array = {5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35};

        longestIncreasingSubsequence(array);
    }

    // O(nlog(n)) time | O(n) space
    public static List<Integer> longestIncreasingSubsequence(int[] array) {
        // Write your code here.
        List<Integer> sequences = new ArrayList<>();
        List<Integer> indices = new ArrayList<>();

        for (int element : array) {
            sequences.add(null);
            indices.add(null);
        }
        indices.add(null);
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int newLength = binarySearch(1, length, indices, array, num);
            sequences.set(i, indices.get(newLength - 1));
            indices.set(newLength, i);
            length = Math.max(length, newLength);
        }
        List<Integer> integers = buildSequence(array, sequences, indices.get(length));
        return integers;
    }

    private static int binarySearch(int startIdx, int endIdx, List<Integer> indices, int[] array, int num) {
        if (startIdx > endIdx) {
            return startIdx;
        }
        int middleIdx = (startIdx + endIdx) / 2;
        if (array[indices.get(middleIdx)] < num) {
            startIdx = middleIdx + 1;
        } else {
            endIdx = middleIdx - 1;
        }
        return binarySearch(startIdx, endIdx, indices, array, num);
    }

    private static List<Integer> buildSequence(int[] array, List<Integer> sequences, Integer currentIdx) {
        List<Integer> sequence = new ArrayList<>();
        while (currentIdx != null) {
            sequence.add(array[currentIdx]);
            currentIdx = sequences.get(currentIdx);
        }
        List<Integer> result = new ArrayList<>();
        int counter = sequence.size() - 1;
        while (counter >= 0) {
            result.add(sequence.get(counter));
            counter--;
        }
        return result;
    }

//    // O(n^2) time | O(n) space
//    public static List<Integer> longestIncreasingSubsequence(int[] array) {
//        // Write your code here.
//        List<Integer> sequences = new ArrayList<>();
//        List<Integer> lengths = new ArrayList<>();
//        int maxLengthIdx = 0;
//        for (int element : array) {
//            lengths.add(1);
//            sequences.add(null);
//        }
//        for (int i = 0; i < array.length; i++) {
//            int currentNum = array[i];
//            for (int j = 0; j < i; j++) {
//                int otherNum = array[j];
//                if (otherNum < currentNum && lengths.get(j) + 1 >= lengths.get(i)) {
//                    lengths.set(i, lengths.get(j) + 1);
//                    sequences.set(i, j);
//                }
//            }
//            if (lengths.get(i) >= lengths.get(maxLengthIdx)) {
//                maxLengthIdx = i;
//            }
//        }
//        List<Integer> integers = buildSequence(array, sequences, maxLengthIdx);
//        return integers;
//    }
//
//    private static List<Integer> buildSequence(int[] array, List<Integer> sequences, Integer currentIdx) {
//        List<Integer> sequence = new ArrayList<>();
//        while (currentIdx != null) {
//            sequence.add(array[currentIdx]);
//            currentIdx = sequences.get(currentIdx);
//        }
//        List<Integer> result = new ArrayList<>();
//        int counter = sequence.size() - 1;
//        while (counter >= 0) {
//            result.add(sequence.get(counter));
//            counter--;
//        }
//        return result;
//    }

}