package december_2025;

import java.util.ArrayDeque;

public class HitCounter3 {

    ArrayDeque<Integer> queue;

    public HitCounter3() {
        queue = new ArrayDeque<>();
    }

    public void hit(int timestamp) {
        queue.addLast(timestamp);
    }

    public int getHits(int timestamp) {
        while (!queue.isEmpty() && timestamp - queue.peek() >= 300) {
            queue.removeFirst();
        }
        return queue.size();
    }

}
