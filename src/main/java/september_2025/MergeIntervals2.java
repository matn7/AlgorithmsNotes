package september_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals2 {

    // O(nlog(n)) time | O(n) space
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][] {};
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] curr = result.get(result.size() - 1);
            if (curr[1] >= interval[0]) {
                curr[0] = Math.min(curr[0], interval[0]);
                curr[1] = Math.max(curr[1], interval[1]);
            } else {
                result.add(interval);
            }
        }
        return result.toArray(new int[][] {});
    }

}
