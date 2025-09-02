package august_2025;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SingleThreadedCPU {

    public static void main(String[] args) {
        int[][] tasks = {{1,2},{2,4},{3,2},{4,1}};

        SingleThreadedCPU singleThreadedCPU = new SingleThreadedCPU();
        int[] result = singleThreadedCPU.getOrder(tasks);
        System.out.println(result);

    }

    // O(nlog(n)) time | O(n) space
    public int[] getOrder(int[][] tasks) {
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = new int[] {tasks[i][0], tasks[i][1], i};
        }

        Arrays.sort(tasks, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> availableTasks = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]
        );

        int time = 0;
        int[] result = new int[tasks.length];
        int idx = 0;
        int i = 0;

        while (idx < tasks.length) {
            while (i < tasks.length && tasks[i][0] <= time) {
                availableTasks.add(new int[] {tasks[i][1], tasks[i][2]});
                i++;
            }

            if (!availableTasks.isEmpty()) {
                int[] task = availableTasks.poll();
                time += task[0];
                result[idx++] = task[1];
            } else {
                if (i < tasks.length) {
                    time = tasks[i][0];
                }
            }
        }

        return result;
    }

}
