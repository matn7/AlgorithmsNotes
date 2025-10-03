package september_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MargeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] result = mergeIntervals.merge(intervals);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] newInterval = intervals[i];
            int[] currInterval = result.get(result.size() - 1);

            if (newInterval[0] <= currInterval[1]) {
                currInterval[0] = Math.min(currInterval[0], newInterval[0]);
                currInterval[1] = Math.max(currInterval[1], newInterval[1]);
            } else {
                result.add(newInterval);
            }
        }

        return result.toArray(new int[][] {});
    }

}
