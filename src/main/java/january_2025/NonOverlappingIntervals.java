package january_2025;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public static void main(String[] args) {
//        int[][] intervals = {{1,2}, {2,3}, {3,4}, {1,3}};
//        int[][] intervals = {{1,2}, {1,2}, {1,2}};

        int[][] intervals = {{1,100},{11,22},{1,11},{2,12}};

        NonOverlappingIntervals overlappingIntervals = new NonOverlappingIntervals();
        int result = overlappingIntervals.eraseOverlapIntervals(intervals);
        System.out.println(result);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start >= prevEnd) {
                prevEnd = end;
            } else {
                count++;
                prevEnd = Math.min(prevEnd, end);
            }
        }

        return count;
    }

}
