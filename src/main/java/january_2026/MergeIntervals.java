package january_2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    // O(nlog(n)) time | O(n) space
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merge = new ArrayList<>();
        merge.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] prev = merge.get(merge.size() - 1);
            int[] curr = intervals[i];

            if (prev[1] >= curr[0]) {
                prev[0] = Math.min(prev[0], curr[0]);
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                merge.add(curr);
            }
        }
        return merge.toArray(new int[merge.size()][2]);
    }

}
