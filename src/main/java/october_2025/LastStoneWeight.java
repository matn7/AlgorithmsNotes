package october_2025;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    // O(nlog(n)) time | O(n) space
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() >= 2) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            int diff = stone1 - stone2;
            if (diff > 0) {
                maxHeap.add(diff);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

}
