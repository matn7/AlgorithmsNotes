package problems.hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class QuickSelect {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 7, 6, 3};

        quickselect(array, 3);
    }

    // O(n) time | O(k) space
    public static int quickselect(int[] array, int k) {
        // Write your code here.
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < array.length; i++) {
            if (heap.size() < k) {
                heap.add(array[i]);
            } else {
                int topElement = heap.peek();
                if (topElement > array[i]) {
                    heap.poll();
                    heap.add(array[i]);
                }
            }
        }

        return heap.peek();
    }

}
