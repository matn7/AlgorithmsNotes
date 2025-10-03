package september_2025;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HandOfStraights {

    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;

        HandOfStraights handOfStraights = new HandOfStraights();
        boolean result = handOfStraights.isNStraightHand(hand, groupSize);
        System.out.println(result);
    }

    // O(n * log(n)) time | O(n) space
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> cardsMap = new HashMap<>();
        for (int h : hand) {
            cardsMap.put(h, cardsMap.getOrDefault(h, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> elem : cardsMap.entrySet()) {
            minHeap.add(elem.getKey());
        }

        while (!minHeap.isEmpty()) {
            // pick first card in sequence
            int first = minHeap.peek();
            for (int j = 0; j < groupSize; j++) {
                int next = first + j;
                if (minHeap.isEmpty() || !cardsMap.containsKey(next)) {
                    return false;
                }
                cardsMap.put(first + j, cardsMap.get(first + j) - 1);
                if (cardsMap.get(first + j) == 0) {
                    cardsMap.remove(first + j);
                    minHeap.poll();
                }
            }
        }
        return true;
    }


}
