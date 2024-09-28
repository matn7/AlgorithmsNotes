package problems.veryhard;

import java.util.ArrayList;
import java.util.List;

public class CountInversions {

    // O(nlog(n)) time | O(n) space
    public int countInversions(int[] array) {
        // Write your code here.
        return countSubArrayInversions(array, 0, array.length);
    }

    public int countSubArrayInversions(int[] array, int start, int end) {
        if (end - start <= 1) {
            return 0;
        }

        int middle = start + (end - start) / 2;
        int leftInversions = countSubArrayInversions(array, start, middle);
        int rightInversions = countSubArrayInversions(array, middle, end);
        int mergedArrayInversions = mergeSortAndCountInversions(array, start, middle, end);
        return leftInversions + rightInversions + mergedArrayInversions;
    }

    private int mergeSortAndCountInversions(int[] array, int start, int middle, int end) {
        List<Integer> sortedArray = new ArrayList<>();
        int left = start;
        int right = middle;
        int inversions = 0;

        while (left < middle && right < end) {
            if (array[left] <= array[right]) {
                sortedArray.add(array[left]);
                left++;
            } else {
                inversions += middle - left;
                sortedArray.add(array[right]);
                right++;
            }
        }

        for (int i = left; i < middle; i++) {
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
