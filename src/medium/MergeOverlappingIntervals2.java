package medium;

import java.util.ArrayList;
import java.util.List;

public class MergeOverlappingIntervals2 {

    public static void main(String[] args) {
        MergeOverlappingIntervals2 mergeOverlappingIntervals = new MergeOverlappingIntervals2();
//        int[][] intervals = {
//                {1, 2},
//                {3, 5},
//                {4, 7},
//                {6, 8},
//                {9, 10}
//        };

        int[][] intervals = {
                {2, 3},
                {4, 5},
                {6, 7},
                {8, 9},
                {1, 10}
        };

        mergeOverlappingIntervals.mergeOverlappingIntervals(intervals);
    }

    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        // Write your code here.
        List<Integer[]> result = new ArrayList<>();
        int colMin = 9999;
        int colMax = -9999;
        for (int row = 0; row < intervals.length; row++) {
            int colStart = intervals[row][0];
            int colEnd = intervals[row][1];
            int temp = colStart;
            boolean changed = false;
            while (row < intervals.length - 1 && colStart < intervals[row + 1][0] && colEnd > intervals[row + 1][0]) {
                if (!changed) {
                    temp = colStart;
                    changed = true;
                }
                row++;
                colStart = intervals[row][0];
                colEnd = intervals[row][1];
                if (colStart < temp) {
                    temp = colStart;
                }
            }
            // Update something
            System.out.println(temp + " " + colEnd);
            Integer[] oneElement = {temp, colEnd};
            result.add(oneElement);
            if (colMin > temp) {
                colMin = temp;
            }
            if (colMax < colEnd) {
                colMax = colEnd;
            }
        }
        int[][] finalResult = new int[result.size()][2];

        for (int i = 0; i < result.size(); i++) {
            finalResult[i][0] = result.get(i)[0];
            finalResult[i][1] = result.get(i)[1];
        }

        return finalResult;
    }
}
