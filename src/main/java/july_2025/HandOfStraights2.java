package july_2025;

import com.sun.source.tree.WhileLoopTree;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HandOfStraights2 {

    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;

        HandOfStraights2 handOfStraights2 = new HandOfStraights2();
        boolean result = handOfStraights2.isNStraightHand(hand, groupSize);
        System.out.println(result);
    }

    // Intuition:
    // - straights - 1, 2, 3 -> 2, 3, 4
    // - count occurrences of cards
    // Approach:
    // - freqMap -> hash map
    // - way to check lowest card in straights -> min heap
    // - how to determine streak? (loop from 0 to groupSize)
    // - way to add back cards [1:2] -> [1:1]
    // - corner cases to check?
    // Complexity:
    // Code:

    // 1,2,3,6,2,3,4,7,8
    // freqMap = {1:1, 2:2, 3:2, 4:1, 6:1, 7:1, 8:1}
    // minHeap = {1, 2, 3, 4, 6, 7, 8}

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int h : hand) {
            freqMap.put(h, freqMap.getOrDefault(h, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> elem : freqMap.entrySet()) {
            minHeap.add(elem.getKey());
        }

        // freqMap = {6:1, 7:1, 8:1}
        // minHeap = {6, 7, 8}
        while (!minHeap.isEmpty()) {
            int current = minHeap.peek(); // 6

            for (int i = 0; i < groupSize; i++) {
                int nextElem = current + i; // 6
                if (minHeap.isEmpty() || !freqMap.containsKey(nextElem)) {
                    return false;
                }
                freqMap.put(nextElem, freqMap.getOrDefault(nextElem, 0) - 1);
                if (freqMap.get(nextElem) == 0) {
                    freqMap.remove(nextElem);
                    minHeap.poll();
                }
            }
        }
        return true;
    }

}
