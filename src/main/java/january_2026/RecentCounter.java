package january_2026;

import java.util.ArrayDeque;

public class RecentCounter {

    // O(1) time | O(n) space
    ArrayDeque<Integer> queue;
    public RecentCounter() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.addLast(t);

        while (!queue.isEmpty() && t - queue.getFirst() > 3000) {
            queue.removeFirst();
        }

        return queue.size();
    }

}
