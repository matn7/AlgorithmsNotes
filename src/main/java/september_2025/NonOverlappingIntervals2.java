package september_2025;

import java.util.Arrays;

public class NonOverlappingIntervals2 {

    public static void main(String[] args) {
//        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
//        int[][] intervals = {{1,2},{1,2},{1,2}};
        int[][] intervals = {{1,100},{11,22},{1,11},{2,12}};

        NonOverlappingIntervals2 nonOverlappingIntervals2 = new NonOverlappingIntervals2();
        int result = nonOverlappingIntervals2.eraseOverlapIntervals(intervals);
        System.out.println(result);

    }

    // O(nlog(n)) time | O(n) space
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            if (currInterval[0] < end) {
                count++;
                end = Math.min(end, currInterval[1]);
            } else {
                end = currInterval[1];
            }
        }
        return count;
    }

}
