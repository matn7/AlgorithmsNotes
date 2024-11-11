package october_2024;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HandOfStraights2 {

    public static void main(String[] args) {
//        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
//        int groupSize = 3;
        int[] hand = {3,4,7,4,6,3,6,5,2,8};
        int groupSize = 2;

        HandOfStraights2 handOfStraights = new HandOfStraights2();
        boolean result = handOfStraights.isNStraightHand(hand, groupSize);
        System.out.println(result);
    }

    // leetcode 846

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> count = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int h : hand) {
            if (!count.containsKey(h)) {
                queue.add(h);
            }
            count.put(h, count.getOrDefault(h, 0) + 1);
        }

        while (!queue.isEmpty()) {
            Integer first = queue.peek();

            for (int i = first; i < first + groupSize; i++) {
                if (!count.containsKey(i)) {
                    return false;
                }
                count.put(i, count.get(i) - 1);
                if (count.get(i) == 0) {
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
