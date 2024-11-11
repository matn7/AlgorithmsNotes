package november_2024;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};

        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        int result = lastStoneWeight.lastStoneWeight(stones);
        System.out.println(result);
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int stone : stones) {
            queue.add(stone);
        }

        while (queue.size() >= 2) {
            int y = queue.poll();
            int x = queue.poll();

            if (x == y) {
                continue;
            }
            y = y - x;
            queue.add(y);
        }

        return queue.isEmpty() ? 0 : queue.poll();
    }

}
