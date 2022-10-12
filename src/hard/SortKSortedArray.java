package hard;

import java.util.PriorityQueue;

public class SortKSortedArray {

    public static void main(String[] args) {

        SortKSortedArray sort = new SortKSortedArray();
        int[] array = {3, 2, 1, 5, 4, 7, 6, 5};
//        int[] array2 = {-1, -3, -4, 2, 1, 3};

        sort.sortKSortedArray(array, 3);
    }

    // O(nlog(k)) time | O(k) space
    //          0  1  2  3  4  5  6  7
    //-------------------------------
    // array = [3, 2, 1, 5, 4, 7, 6, 5]
    // OK - repeated 29/01/2022
    public int[] sortKSortedArray(int[] array, int k) {
        PriorityQueue<Integer> minHeapWithKElements = new PriorityQueue<>();
        for (int i = 0; i < Math.min(array.length, k + 1); i++) {
            // array[3] = 5
            minHeapWithKElements.add(array[i]);
        }
        //     7
        //
        //
        // array = [1, 2, 3, 4, 5, 5, 6, 7]
        int nextIndexToInsertElement = 0;
        for (int idx = k + 1; idx < array.length; idx++) {
            Integer minElement = minHeapWithKElements.poll(); // 3
            array[nextIndexToInsertElement] = minElement;
            nextIndexToInsertElement += 1;

            int currentElement = array[idx]; // 5
            minHeapWithKElements.add(currentElement);
            System.out.println();
        }

        while (!minHeapWithKElements.isEmpty()) {
            int minElement = minHeapWithKElements.poll();
            array[nextIndexToInsertElement] = minElement;
            nextIndexToInsertElement++;
        }

        return array;
    }

}
