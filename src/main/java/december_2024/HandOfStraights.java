package december_2024;

import java.util.*;

public class HandOfStraights {

    public static void main(String[] args) {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};

        HandOfStraights handOfStraights = new HandOfStraights();
        boolean result = handOfStraights.isNStraightHand(hand, 3);
        System.out.println(result);
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> groupMap = new HashMap<>();
        for (int h : hand) {
            groupMap.put(h, groupMap.getOrDefault(h, 0) + 1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (Map.Entry<Integer, Integer> element : groupMap.entrySet()) {
            minHeap.add(new int[] {element.getKey(), element.getValue()});
        }

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll(); // [1, 1]
            Queue<int[]> processedQueue = new LinkedList<>();
            int num = current[0];
            int count = current[1];
            count--;
            if (count > 0) {
                processedQueue.add(new int[] {num, count});
            }
            for (int i = num + 1; i < num + groupSize; i++) {
                if (minHeap.isEmpty() || minHeap.peek()[0] != i) {
                    return false;
                }
                int[] next = minHeap.poll();
                int nextNum = next[0];
                int nextCount = next[1];
                nextCount--;
                if (nextCount > 0) {
                    processedQueue.add(new int[] {nextNum, nextCount});
                }
            }

            for (int[] elem : processedQueue) {
                minHeap.add(new int[]{elem[0], elem[1]});
            }
        }

        return true;
    }

}
