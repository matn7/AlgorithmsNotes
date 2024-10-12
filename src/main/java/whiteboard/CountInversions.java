package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class CountInversions {

    // O(nlog(n)) time | O(n) space
    // rand: 31/07/2022
    public int countInversions(int[] array) {
        // Write your code here.
        return countInversionsHelper(array, 0, array.length);
    }

    private int countInversionsHelper(int[] array, int start, int end) {
        if (end - start <= 1) {
            return 0;
        }

        int mid = start + (end - start) / 2;

        int left = countInversionsHelper(array, start, mid);
        int right = countInversionsHelper(array, mid, end);

        int merged = countAndMerge(array, start, mid, end);
        return left + right + merged;
    }

    private int countAndMerge(int[] array, int start, int mid, int end) {
        List<Integer> sortedArray = new ArrayList<>();
        int left = start;
        int right = mid;
        int inversions = 0;

        while (left < mid && right < end) {
            if (array[left] <= array[right]) {
                sortedArray.add(array[left]);
                left++;
            } else {
                inversions += mid - left;
                sortedArray.add(array[right]);
                right++;
            }
        }

        for (int i = left; i < mid; i++) {
            sortedArray.add(array[i]);
        }

        for (int i = right; i < end; i++) {
            sortedArray.add(array[i]);
        }

        for (int idx = 0; idx < sortedArray.size(); idx++) {
            Integer num = sortedArray.get(idx);
            array[start + idx] = num;
        }
        return inversions;
    }

}
