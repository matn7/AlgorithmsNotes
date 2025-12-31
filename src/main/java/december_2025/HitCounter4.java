package december_2025;

import java.util.ArrayDeque;

public class HitCounter4 {

    ArrayDeque<Integer> queue;

    public HitCounter4() {
        queue = new ArrayDeque<>();
    }

    public void hit(int timestamp) {
        queue.addLast(timestamp);
    }

    public int getHits(int timestamp) {
        while (!queue.isEmpty() && timestamp - queue.getFirst() >= 300) {
            queue.removeFirst();
        }
        return queue.size();
    }

}
