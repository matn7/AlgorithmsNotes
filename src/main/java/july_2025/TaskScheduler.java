package july_2025;

import java.util.*;

public class TaskScheduler {

    public static void main(String[] args) {

        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;

        TaskScheduler taskScheduler = new TaskScheduler();
        int result = taskScheduler.leastInterval(tasks, n);
        System.out.println(result);

    }

    // Intuition:
    // - count tasks - hash map
    // - start from most frequent, keep decrement -> max heap
    // - way to get a task from queue? <count, index>
    // Approach:
    // - create countsMap
    // - create maxHeap add remaining task with idx when next available
    // - in case of no more task just do not add it to max heap
    // Complexity:
    // O(n) time
    // Code:

    // ['A','A','A','B','B','B', 'A'], n = 2
    // countsMap = {'A': 4, 'B': 3}
    // maxHeap = {<3:3>}
    // task 'A' which are 4 unit is available at index 0
    // queue = [<2:4>, <2:6>]

    //             t
    // 0---1---2---3---4---5---6---7---8---9---10---11---12-----------
    // A
    // B
    //
    // if t >= maxHeap.peek()[1] - we can proceed task

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char t : tasks) {
            freqMap.put(t, freqMap.getOrDefault(t, 0) + 1);
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (Map.Entry<Character, Integer> elem : freqMap.entrySet()) {
            maxHeap.add(new int[] {elem.getValue(), 0});
        }
        Queue<int[]> availableQueue = new LinkedList<>();

        int t = 0;
        while (!maxHeap.isEmpty() || !availableQueue.isEmpty()) {
            if (!availableQueue.isEmpty() && availableQueue.peek()[1] <= t) {
                maxHeap.add(availableQueue.poll());
            }
            if (!maxHeap.isEmpty()) {
                int[] current = maxHeap.poll();
                int task = current[0];
                int available = current[1];
                task--;
                if (task > 0) {
                    availableQueue.add(new int[] {task, available + n + 1});
                }
            }
            t++;
        }
        return t;
    }

}
