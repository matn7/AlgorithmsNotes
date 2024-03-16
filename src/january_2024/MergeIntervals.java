package january_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {5, 8}, {4, 10}, {20, 25}};

        mergeIntervals(intervals);
    }

    // O(nlog(n)) time | O(n) space
    public static List<int[]> mergeIntervals(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // [[1, 3], [4, 10], [5, 8], [20, 25]]
        for (int[] interval : intervals) {
            if (result.isEmpty()) {
                result.add(interval);
            } else {
                int[] lastInterval = result.get(result.size() - 1); // [4, 10]
                // interval = [5, 8]
                if (lastInterval[1] < interval[0]) {
                    result.add(interval);
                } else {
                    lastInterval[1] = Math.max(lastInterval[1], interval[1]);
                }
            }
        }

        return result;
    }

}
