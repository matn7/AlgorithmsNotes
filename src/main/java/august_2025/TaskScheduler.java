package august_2025;

import java.util.*;

public class TaskScheduler {

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;

        TaskScheduler taskScheduler = new TaskScheduler();
        int result = taskScheduler.leastInterval(tasks, n);
        System.out.println(result);
    }

    // O(m) time | O(1) space
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (Map.Entry<Integer, Integer> elem : freqMap.entrySet()) {
            maxHeap.add(elem.getValue());
        }
        Queue<int[]> queue = new LinkedList<>();
        while (!maxHeap.isEmpty()) {
            queue.add(new int[] {maxHeap.poll(), 0});
        }
        while (!queue.isEmpty()) {
            if (time >= queue.peek()[1]) {
                int[] current = queue.poll();
                int taskRemaining = current[0];
                int available = current[1];
                taskRemaining--;
                if (taskRemaining > 0) {
                    queue.add(new int[] {taskRemaining, available + n + 1});
                }
            }
            time++;
        }
        return time;
    }

}
