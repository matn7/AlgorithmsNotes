package problems.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {5, 8}, {4, 10}, {20, 25}};

        MergeIntervals mergeIntervals = new MergeIntervals();
        mergeIntervals.merge(intervals);

    }

    // O(nlog(n)) time | O(n) space
    public List<Integer[]> merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<Integer[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (!result.isEmpty() && start <= result.get(result.size() - 1)[1]) {
                Integer[] prev = result.get(result.size() - 1);
                prev[1] = Math.max(prev[1], end);
            } else {
                result.add(new Integer[]{start, end});
            }
        }

        return result;
    }

    // O(n) + O(nlog(n)) time | O(n) space
    public List<Integer[]> mergeIntervals(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // [[1, 3], [4, 10]]
        List<Integer[]> result = new ArrayList<>();

        // [[1, 3], [4, 10], [5, 8], [20, 25]]
        for (int[] interval : intervals) {
            if (result.isEmpty()) {
                result.add(new Integer[]{interval[0], interval[1]});
            } else {
                Integer[] current = result.get(result.size() - 1); // [4, 10]
                if (current[1] > interval[0]) { // 10 > 5
                    current[1] = Math.max(current[1], interval[1]);
                } else {
                    result.add(new Integer[]{interval[0], interval[1]});
                }

            }
        }

        return result;
    }

}
