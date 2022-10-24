package whiteboard;

import java.util.PriorityQueue;

public class SortKSortedArraysMy {

    public static void main(String[] args) {
        int[] array = {3, 2, 1, 5, 4, 7, 6, 5};
        int k = 3;

        SortKSortedArraysMy sortKSortedArray = new SortKSortedArraysMy();
        sortKSortedArray.sortKSortedArray(array, k);
    }

    // O(nlog(k)) time | O(k) space
    public int[] sortKSortedArray(int[] array, int k) {
        // Write your code here.
        if (array.length == 0) {
            return new int[] {};
        }
        int[] result = new int[array.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int counter = 0;
        for (int i = 0; i <= Math.min(array.length - 1, k); i++) {
            queue.add(array[counter]);
            counter++;
        }
        int idx = 0;
        while (counter < array.length) {
            result[idx] = queue.poll();
            idx++;
            queue.add(array[counter]);
            counter++;
        }
        while (!queue.isEmpty()) {
            result[idx] = queue.poll();
            idx++;
        }
        return result;
    }

}
