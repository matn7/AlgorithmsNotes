package whiteboard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class QuickSelect2 {

    public static int quickselect(int[] array, int k) {
        // Write your code here.
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int element : array) {
            if (queue.size() < k) {
                queue.add(element);
            } else {
                Integer top = queue.peek();
                if (element < top) {
                    queue.poll();
                    queue.add(element);
                }
            }
        }
        return queue.peek();
    }

}
