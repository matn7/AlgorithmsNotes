package october_2024;

import java.util.*;

public class HandOfStraights {

    public static void main(String[] args) {
//        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
//        int groupSize = 3;
        int[] hand = {3,4,7,4,6,3,6,5,2,8};
        int groupSize = 2;

        HandOfStraights handOfStraights = new HandOfStraights();
        boolean result = handOfStraights.isNStraightHand(hand, groupSize);
        System.out.println(result);
    }

    // leetcode 846

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (groupSize == 1 || groupSize == hand.length) {
            return true;
        }
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> freqMap = new LinkedHashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int h : hand) {
            if (!freqMap.containsKey(h)) {
                queue.add(h);
            }
            freqMap.put(h, freqMap.getOrDefault(h, 0) + 1);
        }

        while (!queue.isEmpty()) {
            while(!queue.isEmpty() && freqMap.get(queue.peek()) <= 0) {
                queue.poll();
            }
            if (queue.isEmpty()) {
                break;
            }
            Integer peek = queue.peek();
            freqMap.put(peek, freqMap.get(peek) - 1);
            int next = peek;
            for (int i = 1; i < groupSize; i++) {
                next++;
                if (!freqMap.containsKey(next)) {
                    return false;
                }
                freqMap.put(next, freqMap.get(next) - 1);
            }
        }

        return true;
    }

}
