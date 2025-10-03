package september_2025;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};

        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        int result = lastStoneWeight.lastStoneWeight(stones);
        System.out.println(result);

    }

    // O(nlog(n)) time | O(n) space
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() >= 2) {
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            int diff = a - b;
            if (diff > 0) {
                maxHeap.add(diff);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

}
