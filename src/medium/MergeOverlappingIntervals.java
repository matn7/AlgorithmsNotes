package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        MergeOverlappingIntervals mergeOverlappingIntervals = new MergeOverlappingIntervals();

        int[][] intervals = {
                {1, 2},
                {3, 5},
                {4, 7},
                {6, 8},
                {9, 10}
        };

//        int[][] intervals = {
//                {2, 3},
//                {4, 5},
//                {6, 7},
//                {8, 9},
//                {1, 10}
//        };

        mergeOverlappingIntervals.mergeOverlappingIntervals(intervals);
    }

    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        // Write your code here.
        if (intervals.length == 1) {
            return intervals;
        }

        // sort in ascending order
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<Integer[]> resultArray = new ArrayList<>();
        int startOne = 0;
        int endOne = 0;
        int startTwo = 0;
        int endTwo = 0;

        resultArray.add(0, new Integer[] {intervals[0][0], intervals[0][1]});
        int index = 1;

        for (int i = 1; i < intervals.length; i++) {
            startOne = resultArray.get(index - 1)[0];
            endOne = resultArray.get(index - 1)[1];
            startTwo = intervals[i][0];
            endTwo = intervals[i][1];
            // when sorted in ascending order
            if (endOne >= startTwo) {
                // overlap
                int max = Math.max(endOne, endTwo);
                Integer[] integers = resultArray.get(index - 1);
                resultArray.remove(index - 1);
                resultArray.add(new Integer[] {integers[0], max});
            } else {
                index++;
                resultArray.add(new Integer[] {startTwo, endTwo});
            }
        }

        int[][] result = new int[resultArray.size()][2];
        int counter = 0;
        for (Integer[] element : resultArray) {
            result[counter][0] = element[0];
            result[counter][1] = element[1];
            counter++;
        }

        return result;
    }
}
