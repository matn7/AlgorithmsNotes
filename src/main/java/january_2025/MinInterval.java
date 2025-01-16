package january_2025;

import java.util.*;

public class MinInterval {

    public static void main(String[] args) {
        int[][] intervals = {{1,4}, {2,4}, {3,6}, {4,4}};
        int[] queries = {2,3,4,5};

        MinInterval minInterval = new MinInterval();
        int[] result = minInterval.minInterval(intervals, queries);
        System.out.println(result);
    }

    // O(nlog(n) + qlog(q)) time | O(n + q) space
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] sortedQueries = new int[queries.length];
        System.arraycopy(queries, 0, sortedQueries, 0, queries.length);
        Arrays.sort(sortedQueries);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Map<Integer, Integer> resMap = new HashMap<>();
        int idx = 0;
        for (int q : sortedQueries) {
            while (idx < intervals.length && intervals[idx][0] <= q) {
                int l = intervals[idx][0];
                int r = intervals[idx][1];
                minHeap.add(new int[] {r - l + 1, r});
                idx++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < q)  {
                minHeap.poll();
            }
            resMap.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = resMap.get(queries[i]);
        }
        return result;
    }

}
