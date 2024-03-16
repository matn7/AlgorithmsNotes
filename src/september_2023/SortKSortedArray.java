package september_2023;

import java.util.PriorityQueue;

public class SortKSortedArray {

    public static void main(String[] args) {
        int[] array = {1, -3, -4, 2, 1, 3};
        int k = 2;

        SortKSortedArray sortKSortedArray = new SortKSortedArray();
        sortKSortedArray.sortKSortedArray(array, k);
    }

    // O(nlog(k)) time | O(k) space
    public int[] sortKSortedArray(int[] array, int k) {
        // Write your code here.
        //                       *
        // [3, 2, 1, 5, 4, 7, 6, 5]
        if (array.length == 0 || array.length == 1) {
            return array;
        }
        int[] result = new int[array.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>(); // [6, 7]
        for (int i = 0; i <= Math.min(k, array.length-1); i++) {
            queue.add(array[i]);
        }
        int counter = 0;
        for (int i = k+1; i < array.length; i++) {
            Integer top = queue.poll();
            result[counter] = top; // [1, 2, 3, 4, 5, 5
            counter++;
            queue.add(array[i]);
        }
        while (!queue.isEmpty()) {
            Integer top = queue.poll();
            result[counter] = top;
            counter++;
        }
        return result;
    }

}
