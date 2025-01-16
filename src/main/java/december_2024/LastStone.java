package december_2024;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStone {

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};

        LastStone lastStone = new LastStone();
        int result = lastStone.lastStoneWeight(stones);
        System.out.println(result);
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            if (a == b) {
                continue;
            }
            int diff = a - b;
            maxHeap.add(diff);
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

}
