package december_2024;

import java.util.*;

public class LeastInterval {

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;

        LeastInterval leastInterval = new LeastInterval();
        int result = leastInterval.leastInterval(tasks, n);
        System.out.println(result);
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> count = new HashMap<>();
        for (char task : tasks) {
            count.put(task, count.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> element : count.entrySet()) {
            maxHeap.add(element.getValue());
        }

        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                Integer cnt = maxHeap.poll() - 1;
                if (cnt > 0) {
                    q.add(new int[] {cnt, time + n});
                }
            }

            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.add(q.poll()[0]);
            }
        }
        return time;
    }


}
