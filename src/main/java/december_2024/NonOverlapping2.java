package december_2024;


import java.util.Arrays;
import java.util.Comparator;

public class NonOverlapping2 {

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3,4}, {2,3}, {1,3}};

        NonOverlapping2 nonOverlapping2 = new NonOverlapping2();
        int result = nonOverlapping2.eraseOverlapIntervals(intervals);
        System.out.println(result);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));


        // [[1,2], [1,3], [2,3], [3,4]]

        int res = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start >= prevEnd) {
                prevEnd = end;
            } else {
                res++;
                prevEnd = Math.min(prevEnd, end);
            }
        }
        return res;
    }

}
