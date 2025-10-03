package september_2025;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;

        TaskScheduler taskScheduler = new TaskScheduler();
        int result = taskScheduler.leastInterval(tasks, n);
        System.out.println(result);
    }

    // O(n) time | O(26) space
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();
        // O(n) time | O(26) space
        for (char task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]); // [numTasks, available]
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        // O(n) time | O(k) space
        for (Map.Entry<Character, Integer> element : freqMap.entrySet()) {
            maxHeap.add(new int[] {element.getValue(), 0});
        }

        int time = 0;
        while (!queue.isEmpty() || !maxHeap.isEmpty()) {
            // can move task from queue to maxHeap?
            if (!queue.isEmpty() && queue.getFirst()[1] <= time) {
                int[] first = queue.removeFirst(); // O(1)
                maxHeap.add(first); // O(log(k)
            }
            if (!maxHeap.isEmpty()) {
                int[] current = maxHeap.poll();
                int remainingTasks = current[0];
                int available = current[1];
                remainingTasks--;
                if (remainingTasks > 0) {
                    int nextAvailable = time + n + 1;
                    queue.add(new int[] {remainingTasks, nextAvailable});
                }
            }
//            if (maxHeap.isEmpty() && queue.isEmpty()) {
//                break;
//            }
            time++;
        }

        return time;
    }

}
