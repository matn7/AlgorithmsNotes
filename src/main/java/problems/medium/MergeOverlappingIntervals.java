package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {4, 7}, {6, 8}, {9, 10}};
        MergeOverlappingIntervals mergeOverlappingIntervals = new MergeOverlappingIntervals();
        mergeOverlappingIntervals.mergeOverlappingIntervals(intervals);
    }

    // OK - repeated 19/02/2022
    // O(nlog(n)) time | O(n) space
    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        // Write your code here.
        Integer[][] sortedIntervals = new Integer[intervals.length][intervals[0].length];
        for (int i = 0; i < intervals.length; i++) {
            sortedIntervals[i][0] = intervals[i][0];
            sortedIntervals[i][1] = intervals[i][1];
        }
        // sortedIntervals = [[1,2],[3,5],[4,7],[6,8],[9,10]]

        //                      #########
        //              #############
        //  #####   #########               #####
        //  +---+---+---+---+---+---+---+---+---+
        //  1   2   3   4   5   6   7   8   9   10

        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));
        //                                              *
        // sortedIntervals = [[1,2],[3,5],[4,7],[6,8],[9,10]]
        List<Integer[]> mergedIntervals = new ArrayList<>();
        //                     *
        // currentInterval = [9,10]
        Integer[] currentInterval = sortedIntervals[0];
        mergedIntervals.add(currentInterval); // [[1,2],[3,8],[9,10]]

        for (Integer[] nextInterval : sortedIntervals) { // [9,10]
            Integer currentIntervalEnd = currentInterval[1]; // 8
            Integer nextIntervalStart = nextInterval[0]; // 9
            Integer nextIntervalEnd = nextInterval[1]; // 10

            if (currentIntervalEnd >= nextIntervalStart) { // 8 >= 9
                currentInterval[1] = Math.max(currentIntervalEnd, nextIntervalEnd);  // max(7,8) = 8
            } else {
                currentInterval = nextInterval; // [3,5]
                mergedIntervals.add(currentInterval);
            }
        }
        // [[1,2],[3,8],[9,10]]
        int[][] result = new int[mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); i++) {
            result[i][0] = mergedIntervals.get(i)[0];
            result[i][1] = mergedIntervals.get(i)[1];
        }
        return result; // [[1,2],[3,8],[9,10]]
    }

}
