package december_2025;

import java.util.ArrayDeque;

public class HitCounter2 {

    private ArrayDeque<Integer> queue;

    public HitCounter2() {
        queue = new ArrayDeque<>();
    }

    public void hit(int timestamp) {
        queue.addLast(timestamp);
    }

    public int getHits(int timestamp) {
        while (!queue.isEmpty() && queue.getFirst() <= timestamp - 300) {
            queue.removeFirst();
        }
        return queue.size();
    }
}
