package october_2024;

import java.util.*;

public class SingleThreadedCpu {

    public static void main(String[] args) {
        int[][] tasks = {{1, 2}, {2, 4}, {3, 2}, {4, 1}};
//
//        int[][] tasks = {{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}};


        SingleThreadedCpu singleThreadedCpu = new SingleThreadedCpu();
        int[] order = singleThreadedCpu.getOrder(tasks);
        System.out.println(order);
    }

    // leetcode 1834

    // O(nlog(n)) time | O(n) space
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Task> queue = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();
        int n = tasks.length;
        long time = 0; // Track the current time
        int idx = 0; // Index to track tasks

        // Pair each task with its index
        Task[] taskList = new Task[n];
        for (int i = 0; i < n; i++) {
            taskList[i] = new Task(i, tasks[i][0], tasks[i][1]);
        }

        // Sort tasks by enqueue time
        Arrays.sort(taskList, Comparator.comparingLong(t -> t.enqueue));

        while (idx < n || !queue.isEmpty()) {
            // Add all tasks that have arrived by the current time
            while (idx < n && taskList[idx].enqueue <= time) {
                queue.offer(taskList[idx]);
                idx++;
            }

            if (queue.isEmpty()) {
                // If no tasks are available, jump to the next task's enqueue time
                time = taskList[idx].enqueue;
            } else {
                // Process the next task
                Task currentTask = queue.poll();
                result.add(currentTask.index);
                time += currentTask.processing; // Increment time by processing time
            }
        }

        // Convert result to array
        int[] order = new int[n];
        for (int i = 0; i < result.size(); i++) {
            order[i] = result.get(i);
        }

        return order;
    }

    static class Task implements Comparable<Task> {
        int index;
        long enqueue;
        int processing;

        public Task(int index, long enqueue, int processing) {
            this.index = index;
            this.enqueue = enqueue;
            this.processing = processing;
        }

        @Override
        public int compareTo(Task o) {
            if (this.processing == o.processing) {
                return Integer.compare(this.index, o.index); // Sort by index if processing times are the same
            }
            return Integer.compare(this.processing, o.processing); // Sort by processing time
        }
    }

}
