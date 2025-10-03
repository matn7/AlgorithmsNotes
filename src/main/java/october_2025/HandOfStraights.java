package october_2025;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HandOfStraights {

    public static void main(String[] args) {
//        int[] hand = {1,2,3,6,2,3,4,7,8};
//        int groupSize = 3;

        int[] hand = {1, 1, 2, 2, 3, 3};
        int groupSize = 4;

//        int[] hand = {3,4,7,4,6,3,6,5,2,8};
//        int groupSize = 2;

        HandOfStraights handOfStraights = new HandOfStraights();
        boolean result = handOfStraights.isNStraightHand(hand, groupSize);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int h : hand) {
            freqMap.put(h, freqMap.getOrDefault(h, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> element : freqMap.entrySet()) {
            minHeap.add(element.getKey());
        }

        while (minHeap.size() >= groupSize) {
//            while (!minHeap.isEmpty() && freqMap.get(minHeap.peek()) == 0) {
//                minHeap.poll();
//            }
            if (minHeap.isEmpty()) {
                return true;
            }
            int start = minHeap.peek(); // 6
            for (int i = 0; i < groupSize; i++) {
                if (!freqMap.containsKey(start + i)) {
                    return false;
                }
                freqMap.put(start + i, freqMap.get(start + i) - 1);
                if (freqMap.get(start + i) == 0) {
                    freqMap.remove(start + i);
                    minHeap.poll();
                }
            }
        }
        return minHeap.isEmpty();
    }

}
