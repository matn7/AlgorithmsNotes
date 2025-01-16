package december_2024;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinInterval2 {

    public static void main(String[] args) {
        // intervals=[[1,3],[2,3],[3,7],[6,6]]
        // queries=[2,3,1,7,6,8]
        int[][] intervals = {{1, 4}, {2, 4}, {3, 6}, {4,4}};
        int[] queries = {2,3,4,5};

//        int[][] intervals = {{1, 3}, {2, 3}, {3, 7}, {6,6}};
//        int[] queries = {2,3,1,7,6,8};

//        int[][] intervals = {{2,3},{2,5},{1,8},{20,25}};
//        int[] queries = {2,19,5,22};

        MinInterval2 minInterval = new MinInterval2();
        int[] result = minInterval.minInterval(intervals, queries);
        System.out.println(result);
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] result = new int[queries.length];
        int[][] newQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            newQueries[i] = new int[] {queries[i], i};
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(newQueries, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int q = 0; q < queries.length; q++) {
            int query = newQueries[q][0];
            int index = newQueries[q][1];
            for (int[] interval : intervals) {
                int start = interval[0];
                int end = interval[1];
                if (start > query) {
                    break;
                }

                if (query <= end) {
                    minHeap.add(end - start + 1);
                }
            }
            if (minHeap.isEmpty()) {
                result[index] = -1;
            } else {
                result[index] = minHeap.peek();
            }
            minHeap.clear();
        }

        return result;
    }

}
