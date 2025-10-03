package september_2025;

import java.util.Arrays;

public class NonOverlappingIntervals3 {

    public static void main(String[] args) {
//        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
//        int[][] intervals = {{1,2},{1,2},{1,2}};
        int[][] intervals = {{1,2},{2,3}};

        NonOverlappingIntervals3 nonOverlappingIntervals3 = new NonOverlappingIntervals3();
        int result = nonOverlappingIntervals3.eraseOverlapIntervals(intervals);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int count = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] < end) {
                end = Math.min(end, curr[1]);
                count++;
            } else {
                end = curr[1];
            }
        }
        return count;
    }

}
