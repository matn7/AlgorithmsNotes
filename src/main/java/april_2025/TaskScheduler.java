package april_2025;

import java.util.*;

public class TaskScheduler {

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        TaskScheduler taskScheduler = new TaskScheduler();
        int result = taskScheduler.leastInterval(tasks, n);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> tasksFreq = new HashMap<>();
        for (char task : tasks) {
            tasksFreq.put(task, tasksFreq.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (Map.Entry<Character, Integer> elem : tasksFreq.entrySet()) {
            pq.add(elem.getValue());
        }
        Queue<int[]> taskQueue = new LinkedList<>();
        int i = 0;
        while (!pq.isEmpty()) {
            taskQueue.add(new int[] {pq.poll(), i});
            i++;
        }
        int time = 0;
        while (!taskQueue.isEmpty()) {
            int[] checkTask = taskQueue.peek();
            if (checkTask[1] <= time) {
                int[] executeTask = taskQueue.poll();
                executeTask[0]--;
                executeTask[1] = executeTask[1] + (n + 1);
                if (executeTask[0] > 0) {
                    taskQueue.add(executeTask);
                }
            }
            time++;
        }
        return time;
    }

}
