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
    public int[] sortKSortedArray(int[] array, int k) {
        // Write your code here.
        if (array.length == 0) {
            return new int[] {};
        }
        if (k >= array.length) {
            k = array.length - 1;
        }
        int[] sortedArray = new int[array.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int idx = 0;
        for (;idx <= k; idx++) {
            queue.add(array[idx]);
        }
        int i = 0;
        while (!queue.isEmpty() && idx < array.length) {
            Integer currElement = queue.poll();
            sortedArray[i] = currElement;
            i++;
            queue.add(array[idx]);
            idx++;
        }

        while (!queue.isEmpty()) {
            Integer currElement = queue.poll();
            sortedArray[i] = currElement;
            i++;
        }
        return sortedArray;
    }

}
