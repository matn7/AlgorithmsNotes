package december_2025;

import java.util.ArrayDeque;

public class RecentCounter {

    ArrayDeque<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        while (!queue.isEmpty() && t - 3000 > queue.getFirst()) {
            queue.removeFirst();
        }
        queue.addLast(t);
        return queue.size();
    }

}
