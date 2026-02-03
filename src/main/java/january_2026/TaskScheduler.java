package january_2026;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 3;

//        char[] tasks = {'A', 'C', 'A', 'B', 'D', 'B'};
//        int n = 1;

        TaskScheduler taskScheduler = new TaskScheduler();
        int result = taskScheduler.leastInterval(tasks, n);
        System.out.println(result);
    }

    // O(nlog(k)) time | O(k) space
    // k - num of unique chars
    // n - total elems
    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : tasks) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for (Map.Entry<Character, Integer> element : freqMap.entrySet()) {
            maxHeap.add(new int[] {element.getValue(), 0});
        }

        int time = 0;

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            if (!queue.isEmpty() && queue.getFirst()[1] <= time) {
                maxHeap.add(queue.removeFirst());
            }

            if (!maxHeap.isEmpty()) {
                int[] peek = maxHeap.peek();
                if (peek[1] <= time) {
                    int[] pool = maxHeap.poll();
                    pool[0]--;
                    if (pool[0] > 0) {
                        queue.addLast(new int[] {pool[0], time + n + 1});
                    }
                }
            }
            time++;
        }

        return time;
    }


}
