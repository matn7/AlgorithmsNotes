package june_2025;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinInterval2 {

    public static void main(String[] args) {
        int[][] intervals = {{1,4},{2,4},{3,6},{4,4}};
        int[] queries = {2, 3, 4, 5};

//        int[][] intervals = {{2,3},{2,5},{1,8},{20,25}};
//        int[] queries = {2,19,5,22};

        MinInterval2 minInterval2 = new MinInterval2();
        int[] result = minInterval2.minInterval(intervals, queries);
        for (int num : result) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] result = new int[queries.length];
        int j = 0;

        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i] = new int[] {i, queries[i]};
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(sortedQueries, (a, b) -> a[1] - b[1]);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < sortedQueries.length; i++) {
            int query = sortedQueries[i][1];

            while (j < intervals.length && query >= intervals[j][0]) {
                int dist = intervals[j][1] - intervals[j][0] + 1;
                minHeap.add(new int[] {dist, intervals[j][1]});
                j++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }

            int idx = sortedQueries[i][0];
            if (minHeap.isEmpty()) {
                result[idx] = -1;
            } else {
                result[idx] = minHeap.peek()[0];
            }
        }

        return result;
    }

}
