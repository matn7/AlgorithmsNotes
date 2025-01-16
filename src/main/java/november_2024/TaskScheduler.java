package november_2024;

import java.util.*;

public class TaskScheduler {

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'C', 'C'};
        int n = 1;

        TaskScheduler taskScheduler = new TaskScheduler();
        int result = taskScheduler.leastInterval(tasks, n);
        System.out.println(result);
    }

    // O(n * m) time
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> count = new HashMap<>();
        for (char task : tasks) {
            count.put(task, count.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (Map.Entry<Character, Integer> element : count.entrySet()) {
            maxHeap.add(element.getValue());
        }

        int time = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                Integer cnt = maxHeap.poll() - 1;
                if (cnt != 0) {
                    queue.addLast(new int[] {cnt, time + n});
                }
            }
            if (!queue.isEmpty() && queue.getFirst()[1] == time) {
                maxHeap.add(queue.removeFirst()[0]);
            }
        }

        return time;
    }

}
