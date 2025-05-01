package april_2025;

import java.util.Arrays;

public class NonOverlappingIntervals2 {

    public static void main(String[] args) {
//        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1,3}};
        int[][] intervals = {{1, 2}, {1, 2}, {1, 2}};

        NonOverlappingIntervals2 nonOverlappingIntervals2 = new NonOverlappingIntervals2();
        int result = nonOverlappingIntervals2.eraseOverlapIntervals(intervals);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space - spec e used by sorting
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int endInterval = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (endInterval > curr[0]) {
                count++;
                endInterval = Math.min(endInterval, curr[1]);
            } else {
                endInterval = curr[1];
            }
        }
        return count;
    }

}
