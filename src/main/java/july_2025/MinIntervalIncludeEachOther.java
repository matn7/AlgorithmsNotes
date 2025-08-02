package july_2025;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinIntervalIncludeEachOther {

    public static void main(String[] args) {
//        int[][] intervals = {{2,3},{2,5},{1,8},{20,25}};
//        int[] queries = {2,19,5,22};

//        int[][] intervals = {{1,4},{2,4},{3,6},{4,4}};
//        int[] queries = {2,3,4,5};

        int[][] intervals = {{4,5},{5,8},{1,9},{8,10},{1,6}};
        int[] queries = {7,9,3,9,3};

        MinIntervalIncludeEachOther minIntervalIncludeEachOther = new MinIntervalIncludeEachOther();
        int[] result = minIntervalIncludeEachOther.minInterval(intervals, queries);
        System.out.println(result);
    }

    // Intuition:
    // - sort, draw picture
    // - keep track of min interval within range -> PriorityQueue
    // - keep removing intervals, based on idx? -> store <interval, idx> in PQ
    // Approach:
    // - sort queries ? Yes
    // - sort based on interval[0]
    // - There are no valid intervals for query: -1
    // - query = 5
    // - remove elemes from minHeap which not match query (end index is < query) -> (actually add first then remove)
    // - j = 0 keep track queries                                                 j
    // - keep calc interval which are withing query range. query = 2 -> [1, 4], [2, 4], [3, 6] is out of range
    //                                                                                     j
    // - keep calc interval which are withing query range. query = 3 -> [1, 4], [2, 4], [3, 6], [4, 4] is out of range
    //                                                                                            j
    // - keep calc interval which are withing query range. query = 4 -> [1, 4], [2, 4], [3, 6], [4, 4]
    // - store intervals in PQ (minHeap): [<4, 4>, <3, 4>, <4, 6>, <1, 4>] (before query 5)
    // - store intervals in PQ (minHeap): [<4, 6>] (before query 5)
    // - Add to result: [3, 3, 1, 4]
    // Complexity:
    // O(nlog(n) + mlog(m)) time | O(n + m) space
    // Code:

    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] - b[0] == 0) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int[][] sortedQuery = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQuery[i] = new int[] {queries[i], i};
        }
        Arrays.sort(sortedQuery, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int[] result = new int[queries.length];
        int j = 0;

        for (int[] query : sortedQuery) {
            int q = query[0];
            while (j < intervals.length && intervals[j][0] <= q) {
                int dist = intervals[j][1] - intervals[j][0] + 1;
                minHeap.add(new int[] {dist, intervals[j][1]});
                j++;
            }

            while (!minHeap.isEmpty() && q > minHeap.peek()[1]) {
                minHeap.poll();
            }
            int idx = query[1];
            if (minHeap.isEmpty()) {
                result[idx] = -1;
            } else {
                result[idx] = minHeap.peek()[0];
            }
        }
        return result;
    }

}
