package july_2025;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervals =  {{1,2},{2,3},{3,4},{1,3}};
        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();
        int result = nonOverlappingIntervals.eraseOverlapIntervals(intervals);
        System.out.println(result);
    }

    // Intuition:
    // - Sorted?
    // - Draw picture.
    // - Keep track of end interval
    // Approach:
    // - sort
    // - add endInterval variable
    // - [1, 2], [2, 4] overlap? No
    // Complexity:
    // O(n) time | O(1) space
    // Code:

    //               3-----4
    //         2-----3
    //   1-----------3                      curr
    //   1-----2
    // ------------------------------------

    // endInterval = 2
    // currStart = 2
    // currStart < endInterval -> set end min(endInterval, currEnd)
    // else: endInterval = currEnd

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int endInterval = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] < endInterval) {
                count++;
                endInterval = Math.min(endInterval, curr[1]);
            } else {
                endInterval = curr[1];
            }
        }
        return count;
    }

}
