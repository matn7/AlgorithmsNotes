package june_2025;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1,2}, {2,3}, {3,4}, {1,3}};

        EraseOverlapIntervals eraseOverlapIntervals = new EraseOverlapIntervals();
        int result = eraseOverlapIntervals.eraseOverlapIntervals(intervals);
        System.out.println(result);
    }

    // O(n log(n)) time | O(1) space
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int endInterval = intervals[0][1];
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] >= endInterval) {
                endInterval = curr[1];
            } else {
                count++;
                endInterval = Math.min(endInterval, curr[1]);
            }
        }

        return count;
    }

}
