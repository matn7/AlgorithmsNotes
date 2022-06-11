package whiteboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] array = {5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35};

        longestIncreasingSubsequence(array);
    }

    // O(n^2) time | O(n) space
    public static List<Integer> longestIncreasingSubsequence(int[] array) {
        // Write your code here.
        List<Integer> sequence = new ArrayList<>();
        List<Integer> lengths = new ArrayList<>();
        for (int element : array) {
            sequence.add(null);
            lengths.add(1);
        }
        int maxLenIdx = 0;
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            for (int j = 0; j < i; j++) {
                int other = array[j];
                if (other < current && lengths.get(j) + 1 >= lengths.get(i)) {
                    lengths.set(i, lengths.get(j) + 1);
                    sequence.set(i, j);
                }
            }
            if (lengths.get(i) >= lengths.get(maxLenIdx)) {
                maxLenIdx = i;
            }
        }

        List<Integer> result = buildSequence(sequence, maxLenIdx, array);
        Collections.reverse(result);
        return result;
    }

    private static List<Integer> buildSequence(List<Integer> sequence, int maxLenIdx, int[] array) {
        List<Integer> result = new ArrayList<>();
        Integer next = maxLenIdx;
        while (next != null) {
            result.add(array[next]);
            next = sequence.get(next);
        }
        return result;
    }

}
