package june_2025;

import java.util.*;

public class HandOfStraights {

    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;

        HandOfStraights handOfStraights = new HandOfStraights();
        boolean result = handOfStraights.isNStraightHand(hand, groupSize);
        System.out.println(result);
    }

    // O(n log(n)) time | O(n) space
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int h : hand) {
            freqMap.put(h, freqMap.getOrDefault(h, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> elem : freqMap.entrySet()) {
            queue.add(elem.getKey());
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int group = groupSize;
            List<Integer> list = new ArrayList<>();
            freqMap.put(current, freqMap.getOrDefault(current, 0 ) - 1);
            if (freqMap.get(current) > 0) {
                list.add(current);
            }
            group--;
            while (!queue.isEmpty() && queue.peek() == current + 1 && group > 0) {
                int poll = queue.poll();
                freqMap.put(poll, freqMap.getOrDefault(poll, 0) - 1);
                if (freqMap.get(poll) > 0) {
                    list.add(poll);
                }
                current = poll;
                group--;
            }
            if (group != 0) {
                return false;
            }
            for (int elem : list) {
                queue.add(elem);
            }
        }
        return true;
    }

}
