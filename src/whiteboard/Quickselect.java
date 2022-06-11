package whiteboard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Quickselect {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 7, 6, 3};

        quickselect(array, 3);
    }

    // O(nlog(n)) time | O(n) space
    public static int quickselect(int[] array, int k) {
        // Write your code here.
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int element : array) {
            if (queue.size() < k) {
                queue.add(element);
            } else {
                int topElement = queue.peek();
                if (topElement > element) {
                    queue.poll();
                    queue.add(element);
                }
            }
        }

        return queue.peek();
    }

}
