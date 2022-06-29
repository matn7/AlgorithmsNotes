package whiteboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1,2}, {3,5}, {4,7}, {6,8}, {9,10}};
        MergeOverlappingIntervals merge = new MergeOverlappingIntervals();
        merge.mergeOverlappingIntervals(intervals);
    }

    // O(nlog(n)) time | O(n) space
    // #2: 23/06/2022
    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        // Write your code here.
        if (intervals.length == 0) {
            return new int[][] {};
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> resultArray = new ArrayList<>();
        resultArray.add(intervals[0]);
        for (int currIdx = 1; currIdx < intervals.length; currIdx++) {
            int[] current = intervals[currIdx];
            int[] prev = resultArray.get(resultArray.size() - 1);
            if (current[0] <=
                    prev[1]) {
                prev[1] = Math.max(prev[1], current[1]);
            } else {
                resultArray.add(current);
            }
        }
        int[][] result = new int[resultArray.size()][2];
        for (int i = 0; i < resultArray.size(); i++) {
            result[i][0] = resultArray.get(i)[0];
            result[i][1] = resultArray.get(i)[1];
        }
        return result;
    }

}
