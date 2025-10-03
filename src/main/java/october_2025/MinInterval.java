package october_2025;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinInterval {

    public static void main(String[] args) {
//        int[][] intervals = {{1,4},{2,4},{3,6},{4,4}};
//        int[] queries = {2,3,4,5};

//        int[][] intervals = {{2,3},{2,5},{1,8},{20,25}};
//        int[] queries = {2,19,5,22};

        int[][] intervals = {{4,5},{5,8},{1,9},{8,10},{1,6}};
        int[] queries = {7,9,3,9,3};

        MinInterval minInterval = new MinInterval();
        int[] result = minInterval.minInterval(intervals, queries);
        System.out.println(result);

    }

    // O(nlog(n) + mlog(m)) time | O(n + m) space
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[][] queries2d = new int[queries.length][1];
        for (int i = 0; i < queries.length; i++) {
            queries2d[i] = new int[] {queries[i], i};
        }
        Arrays.sort(queries2d, (a, b) -> a[0] - b[0]);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] result = new int[queries.length];
        int idx2 = 0; // iterate through intervals
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]); // [startIdx, endIdx, size]

        for (int[] query2d : queries2d) { // 2
            // remove from heap out of range interval
            int query = query2d[0];

            while (idx2 < intervals.length && query >= intervals[idx2][0]) { // 2 >= 1
                int[] currInterval = intervals[idx2]; // [1,4]
                int startIdx = currInterval[0];
                int endIdx = currInterval[1];
                int size = currInterval[1] - currInterval[0] + 1;
                minHeap.add(new int[] {startIdx, endIdx, size});
                idx2++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }

            int idx1 = query2d[1];
            if (minHeap.isEmpty()) {
                result[idx1] = -1;
            } else {
                int[] matchInterval = minHeap.peek();
                result[idx1] = matchInterval[2];
            }
        }
        return result;
    }

}
