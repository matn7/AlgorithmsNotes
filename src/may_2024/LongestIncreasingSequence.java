package may_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSequence {

    public static void main(String[] args) {
        int[] arr = {5, 7, -22, 12, 10, 2, 3, 12, 5, 6, 35};

        longestSequence(arr);
    }

    // O(n^2) time | O(n) space
    public static List<Integer> longestSequence(int[] array) {
        int[] counts = new int[array.length];
        Integer[] sequence = new Integer[array.length];
        Arrays.fill(sequence, null);
        int maxIdx = 0;

        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int other = array[j];
                if (current < other) {
                    if (counts[i] + 1 > counts[j]) {
                        counts[j] = counts[i] + 1;
                        sequence[j] = i;
                        if (counts[maxIdx] < counts[j]) {
                            maxIdx = j;
                        }
                    }
                }
            }
        }

        List<Integer> result = buildSequence(array, sequence, maxIdx);
        Collections.reverse(result);

        return result;
    }

    private static List<Integer> buildSequence(int[] array, Integer[] sequence, int maxIdx) {
        List<Integer> result = new ArrayList<>();
        Integer currentIdx = maxIdx;
        while (currentIdx != null) {
            result.add(array[currentIdx]);
            currentIdx = sequence[currentIdx];
        }
        return result;
    }

}
