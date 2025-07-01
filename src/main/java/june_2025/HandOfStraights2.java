package june_2025;

import java.util.*;

public class HandOfStraights2 {

    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
//        int[] hand = {8, 10, 12};
        int groupSize = 3;

//        int[] hand = {1, 1, 2, 2, 3, 3};
//        int groupSize = 2;

        HandOfStraights2 handOfStraights2 = new HandOfStraights2();
        boolean result = handOfStraights2.isNStraightHand(hand, groupSize);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> counts = new HashMap<>();
        for (int h : hand) {
            counts.put(h, counts.getOrDefault(h, 0) + 1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> elems : counts.entrySet()) {
            minHeap.add(new int[] {elems.getKey(), elems.getValue()});
        }

        while (!minHeap.isEmpty()) {
            int[] prev = minHeap.peek();
            int start = prev[0];
            List<int[]> addback = new ArrayList<>();

            for (int i = 0; i < groupSize; i++) {
                if (minHeap.isEmpty()) {
                    return false;
                }
                int[] curr = minHeap.poll();
                if (curr[0] != i + start) {
                    return false;
                }
                curr[1]--;
                if (curr[1] > 0) {
                    addback.add(curr);
                }
            }

            for (int[] c : addback) {
                minHeap.add(c);
            }
        }
        return true;
    }

}
