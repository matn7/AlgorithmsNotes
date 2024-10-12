package whiteboard;

import java.util.PriorityQueue;

public class SortKSortedArray {

    public static void main(String[] args) {
//        int[] array = {3, 2, 1, 5, 4, 7, 6, 5};
        int[] array = {5, 4, 3, 2, -100};
        SortKSortedArray sort = new SortKSortedArray();
        sort.sortKSortedArray(array, 5);
    }

    // O(nlog(k)) time | O(k) space
    // rand: 06/08/2022
    public int[] sortKSortedArray(int[] array, int k) {
        // Write your code here.
        if (array.length == 0) {
            return new int[] {};
        }
        int[] result = new int[array.length];

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int counter = 0;
        while (counter <= Math.min(array.length - 1, k)) {
            queue.add(array[counter]);
            counter++;
        }
        int idx = 0;
        while (counter < array.length) {
            Integer top = queue.poll();
            result[idx] = top;
            idx++;
            queue.add(array[counter]);
            counter++;
        }

        while (!queue.isEmpty()) {
            Integer top = queue.poll();
            result[idx] = top;
            idx++;
        }

        return result;
    }

}
