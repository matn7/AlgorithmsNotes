package july_2025;

import java.util.*;

public class HandOfStraights {

    public static void main(String[] args) {
//        int[] hand = {1,2,3,6,2,3,4,7,8};
//        int groupSize = 3;

//        int[] hand = {1,2,3,4,5};
//        int groupSize = 4;

//        int[] hand = {1, 5};
//        int groupSize = 2;

        int[] hand = {1, 1, 2, 2, 3, 3};
        int groupSize = 2;

        HandOfStraights handOfStraights = new HandOfStraights();
        boolean result = handOfStraights.isNStraightHand(hand, groupSize);
        System.out.println(result);
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int h : hand) {
            freqMap.put(h, freqMap.getOrDefault(h, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(freqMap.keySet());

        while (!queue.isEmpty()) {
            int curr = queue.peek();
            for (int i = curr; i < curr + groupSize; i++) {
                if (!freqMap.containsKey(i)) {
                    return false;
                }
                freqMap.put(i, freqMap.get(i) - 1);
                if (freqMap.get(i) == 0) {
                    if (i != queue.peek()) {
                        return false;
                    }
                    queue.poll();
                }
            }
        }
        return true;
    }

}
