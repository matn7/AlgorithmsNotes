package may_2025;

import java.util.*;

public class LeastInterval {

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        LeastInterval leastInterval = new LeastInterval();
        int result = leastInterval.leastInterval(tasks, n);
        System.out.println(result);
    }

    // O(m) time | O(m) space
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : tasks) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (Map.Entry<Character, Integer> elem : freq.entrySet()) {
            maxHeap.add(elem.getValue());
        }
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            if (!queue.isEmpty() && queue.peek()[1] <= time) {
                maxHeap.add(queue.poll()[0]);
            }
            if (!maxHeap.isEmpty()) {
                int poll = maxHeap.poll();
                if (poll > 1) {
                    queue.add(new int[] {poll - 1, time + n + 1});
                }
            }
            time++;
        }

        return time;
    }

}
