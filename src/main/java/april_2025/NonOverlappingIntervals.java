package april_2025;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1,2}, {2,3}, {3,4}, {1,3}};

        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();
        int result = nonOverlappingIntervals.eraseOverlapIntervals(intervals);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(1) space
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int count = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] >= end) {
                end = curr[1];
            } else {
                end = Math.min(end, curr[1]);
                count++;
            }
        }
        return count;
    }

}
