package december_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval2 {

    public static void main(String[] args) {
        // int[][] intervals = {{1, 3}, {6, 9}};
        // int[] newInterval = {2, 5};

        // intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]

        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};

        InsertInterval2 insertInterval = new InsertInterval2();
        int[][] insert = insertInterval.insert(intervals, newInterval);
        System.out.println(insert);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newInterval == null || interval[1] < newInterval[0]) {
                // START
                res.add(interval);
            } else if (interval[0] > newInterval[1]) {
                // end
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        if (newInterval != null) {
            res.add(newInterval);
        }
        return res.toArray(new int[res.size()][]);
    }


}
