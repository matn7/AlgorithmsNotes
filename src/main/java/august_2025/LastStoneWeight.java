package august_2025;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    // O(n log(n)) time | O(n) space
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int stone : stones) {
            queue.add(stone);
        }

        while (queue.size() >= 2) {
            int x = queue.poll();
            int y = queue.poll();
            if (x != y) {
                queue.add(x - y);
            }
        }
        return queue.isEmpty() ? 0 : queue.peek();
    }

}
