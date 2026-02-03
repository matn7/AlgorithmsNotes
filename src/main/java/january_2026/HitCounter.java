package january_2026;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class HitCounter {

    LinkedList<Integer> queue;

    public HitCounter() {
        queue = new LinkedList<>();
    }

    public void hit(int timestamp) {
        queue.addLast(timestamp);
    }

    public int getHits(int timestamp) {
        // getHits(4) =     4 - 1 >= 300 NO
        // getHits(300) = 300 - 1 >= 300 NO
        // getHits(301) = 301 - 1 >= 300 YES
        // [1, 2, 3, 300, ]
        while (!queue.isEmpty() && timestamp - queue.getFirst() >= 300) {
            queue.removeFirst();
        }
        return queue.size();
    }

}
