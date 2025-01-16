package december_2024;

import java.util.*;

public class MinInterval3 {

    public static void main(String[] args) {
        // intervals=[[1,3],[2,3],[3,7],[6,6]]
        // queries=[2,3,1,7,6,8]
//        int[][] intervals = {{1, 4}, {2, 4}, {3, 6}, {4,4}};
//        int[] queries = {2,3,4,5}; // [3, 3, 1, 4]

        int[][] intervals = {{1, 3}, {2, 3}, {3, 7}, {6,6}};
        int[] queries = {2,3,1,7,6,8};

//        int[][] intervals = {{2,3},{2,5},{1,8},{20,25}};
//        int[] queries = {2,19,5,22};

        MinInterval3 minInterval = new MinInterval3();
        int[] result = minInterval.minInterval(intervals, queries);
        System.out.println(result);
    }

    // O(nlog(n) + qlog(q)) time | O (n + q) space
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Map<Integer, Integer> res = new HashMap<>();
        int i = 0;
        for (int q : Arrays.stream(queries).sorted().toArray()) {
            while (i < intervals.length && intervals[i][0] <= q) {
                int l = intervals[i][0];
                int r = intervals[i][1];
                minHeap.offer(new int[]{r - l + 1, r});
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }
            res.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }
        int[] result = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            result[j] = res.get(queries[j]);
        }
        return result;
    }


}
