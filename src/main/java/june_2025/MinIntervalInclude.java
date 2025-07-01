package june_2025;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinIntervalInclude {

    public static void main(String[] args) {
//        int[][] intervals = {{1,4},{2,4},{3,6},{4,4}};
//        int[] queries = {2, 3, 4, 5};

//        int[][] intervals = {{2,3},{2,5},{1,8},{20,25}};
//        int[] queries = {2, 19, 5, 22};

        int[][] intervals = {{4,5},{5,8},{1,9},{8,10},{1,6}};
        int[] queries = {7,9,3,9,3};
        // 2,3,6,3,6

        MinIntervalInclude minIntervalInclude = new MinIntervalInclude();

        int[] result = minIntervalInclude.minInterval(intervals, queries);
        System.out.println(result);

    }

    // O(nlog(n) + mlog(m)) time | O(m + n) space
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[][] newQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            newQueries[i] = new int[] {queries[i], i};
        }
        Arrays.sort(newQueries, (a, b) -> a[0] - b[0]);
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[0] - b[0] == 0) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int[] result = new int[newQueries.length];
        int intervalIdx = 0;
        int idx = 0;
        for (int query[] : newQueries) {
            while (intervalIdx < intervals.length) {
                int[] interval = intervals[intervalIdx];
                if (interval[0] > query[0]) {
                    break;
                }
                queue.add(new int[] {interval[1] - interval[0] + 1, interval[1]});
                intervalIdx++;
            }
            while (!queue.isEmpty() && queue.peek()[1] < query[0]) {
                queue.poll();
            }
            result[newQueries[idx][1]] = queue.isEmpty() ? -1 : queue.peek()[0];
            idx++;
        }

        return result;
    }

}
