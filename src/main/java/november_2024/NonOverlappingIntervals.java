package november_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NonOverlappingIntervals {

    public static void main(String[] args) {
//        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        // [1,100],[11,22],[1,11],[2,12]
        int[][] intervals = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};

        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();
        int result = nonOverlappingIntervals.eraseOverlapIntervals(intervals);
        System.out.println(result);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort intervals by end time (second value) to apply the greedy strategy
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int count = 0;
        int prevEnd = Integer.MIN_VALUE; // Track the end of the last added interval

        for (int[] interval : intervals) {
            if (interval[0] < prevEnd) { // If the current interval starts before the last one ends, it's overlapping
                count++; // We need to remove this interval to avoid overlap
            } else {
                prevEnd = interval[1]; // No overlap, update prevEnd to the current interval's end
            }
        }

        return count;
    }

}
