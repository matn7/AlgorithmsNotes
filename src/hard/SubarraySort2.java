package hard;

import java.util.*;

public class SubarraySort2 {

    public static void main(String[] args) {
//        int[] array = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};

//        int[] array = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89};

//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2};

        subarraySort(array);
    }

    // O(N) time | O(1) space
    public static int[] subarraySort(int[] array) {

        if (array.length == 2) {
            if (array[0] > array[1]) {
                return new int[] {0, 1};
            } else {
                return new int[]{-1, -1};
            }
        }

        // always at least 2 numbers not sorted
        int minUnsorted = 9999;
        int maxUnsorted = -9999;
        int unsortedElements = 0;
        for (int i = 1; i < array.length - 1; i++) {
            // determine number out of order
            if (array[i] >= array[i - 1] && array[i] <= array[i + 1]) {
                // good - sorted
            } else {
                // unsorted
                if (array[i] < minUnsorted) {
                    minUnsorted = array[i];
                }
                if (array[i] > maxUnsorted) {
                    maxUnsorted = array[i];
                }
                unsortedElements++;
            }
        }

        // check last index
        if (array[array.length - 1] < minUnsorted) {
            minUnsorted = array[array.length - 1];
        }

        if (unsortedElements == 0) {
            return new int[] {-1, -1};
        }

        // find smallest unsorted number
        // find greatest unsorted number
        // what is a final position of greatest element in array
        int minIdx = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > minUnsorted) {
                minIdx = i;
                break;
            }
        }

        int maxIdx = array.length - 1;
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] < maxUnsorted) {
                maxIdx = i;
                break;
            }
        }

        return new int[] {minIdx, maxIdx};
    }

}
