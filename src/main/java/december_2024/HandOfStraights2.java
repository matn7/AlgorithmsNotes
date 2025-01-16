package december_2024;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HandOfStraights2 {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for (int n : hand) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> minH = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> elem : count.entrySet()) {
            minH.add(elem.getKey());
        }

        while (!minH.isEmpty()) {
            int first = minH.peek();

            for (int i = first; i < first + groupSize; i++) {
                if (!count.containsKey(i)) {
                    return false;
                }
                count.put(i, count.getOrDefault(i, 0) - 1);
                if (count.get(i) == 0) {
                    if (i != minH.peek()) {
                        return false;
                    }
                    minH.poll();
                }
            }
        }
        return true;
    }

}
