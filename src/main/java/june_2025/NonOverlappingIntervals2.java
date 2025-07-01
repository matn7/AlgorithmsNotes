package june_2025;

import java.util.Arrays;

public class NonOverlappingIntervals2 {

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};

        NonOverlappingIntervals2 nonOverlappingIntervals2 = new NonOverlappingIntervals2();
        int result = nonOverlappingIntervals2.eraseOverlapIntervals(intervals);
        System.out.println(result);

    }

    // O(nlog(n)) time | O(n) space
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int prevEnd = intervals[0][1];

        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            if (start < prevEnd) {
                prevEnd = Math.min(prevEnd, intervals[i][1]);
                res++;
            } else {
                prevEnd = intervals[i][1];
            }
        }
        return res;
    }

}
