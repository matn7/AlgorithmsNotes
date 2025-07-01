package june_2025;

import java.util.*;

public class TaskScheduler {

    public static void main(String[] args) {
//        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
//        int n = 2;
//
        char[] tasks = {'B', 'C', 'D', 'A', 'A', 'A', 'A', 'G'};
        int n = 1;

        TaskScheduler taskScheduler = new TaskScheduler();
        int result = taskScheduler.leastInterval(tasks, n);
        System.out.println(result);
    }

    // O(n) time | O(m) space
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char task : tasks) {
            counts.put(task, counts.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (Map.Entry<Character, Integer> elems : counts.entrySet()) {
            maxHeap.add(elems.getValue());
        }

        Queue<int[]> queue = new LinkedList<>();
        while (!maxHeap.isEmpty()) {
            queue.add(new int[] {maxHeap.poll(), 0});
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int[] peek = queue.peek();
            if (time >= peek[1]) {
                // task is available
                int[] current = queue.poll();
                int task = current[0];
                int avail = current[1];
                task--;
                if (task > 0) {
                    queue.add(new int[] {task, avail + n + 1});
                }
            }

            time++;
        }
        return time;
    }

}
