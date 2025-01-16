package january_2025;

import java.util.*;

public class TaskScheduler {

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;

        TaskScheduler taskScheduler = new TaskScheduler();
        int result = taskScheduler.leastInterval(tasks, n);
        System.out.println(result);
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char t : tasks) {
            freqMap.put(t, freqMap.getOrDefault(t, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (Map.Entry<Character, Integer> element : freqMap.entrySet()) {
            maxHeap.add(element.getValue());
        }

        Queue<int[]> q = new LinkedList<>();

        int time = 0;
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int count = maxHeap.poll() - 1;
                if (count > 0) {
                    q.add(new int[] {count, time + n});
                }
            }

            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.add(q.poll()[0]);
            }
        }
        return time;
    }

}
