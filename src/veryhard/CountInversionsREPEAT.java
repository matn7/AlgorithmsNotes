package veryhard;

import java.util.ArrayList;
import java.util.List;

public class CountInversionsREPEAT {

    public static void main(String[] args) {
        int[] array = {2, 3, 3, 1, 9, 5, 6};

        CountInversionsREPEAT countInversionsREPEAT = new CountInversionsREPEAT();
        int i = countInversionsREPEAT.countInversions(array);
        System.out.println(i);
    }

    // OK - repeated 23/02/2022
    // O(nlog(n)) time | O(n) space
    public int countInversions(int[] array) {
        // Write your code here.
        // rec([2, 3, 3, 1, 9, 5, 6], 0, 7)
        return countSubArrayInversions(array, 0, array.length);
    }


    // rec([2, 3, 3, 1, 9, 5, 6], 2, 3) =>0
    // rec([2, 3, 3, 1, 9, 5, 6], 1, 2) =>0
    // rec([2, 3, 3, 1, 9, 5, 6], 1, 3) m=2, l=0, r=0 *
    // rec([2, 3, 3, 1, 9, 5, 6], 0, 1) =>0
    // rec([2, 3, 3, 1, 9, 5, 6], 0, 3) m=1, l=0, r=
    // rec([2, 3, 3, 1, 9, 5, 6], 0, 7) m=3, l=, r=
    private int countSubArrayInversions(int[]array, int start, int end) {
        if (end - start <= 1) { // 3 - 1 <= 1
            return 0;
        }

        // 1 + (3 - 1) / 2 = 2
        int middle = start + (end - start) / 2;
        int leftInversions = countSubArrayInversions(array, start, middle); // 0
        int rightInversions = countSubArrayInversions(array, middle, end); // 0

        // rec([2, 3, 3, 1, 9, 5, 6], 1, 2, 3)
        int mergedArrayInversions = mergeSortAndCountInversions(array, start, middle, end);
        return leftInversions + rightInversions + mergedArrayInversions;
    }

    //         l  r  e
    // rec([2, 3, 3, 1, 9, 5, 6], 1, 2, 3)
    private int mergeSortAndCountInversions(int[] array, int start, int middle, int end) {
        List<Integer> sortedArray = new ArrayList<>(); // [3,3]
        int left = start; // 1
        int right = middle; // 3
        int inversions = 0;

        while (left < middle && right < end) {
            if (array[left] <= array[right]) { // 3 <= 1
                sortedArray.add(array[left]);
                left++;
            } else {
                inversions += middle - left; // 0 + (2 - 1) = 1
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
