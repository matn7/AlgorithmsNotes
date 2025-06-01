package may_2025;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
//        int[][] intervals = {{1,2}, {3,5}, {6,7}, {8,10}, {12,16}};
        int[][] intervals = {};
        int[] newInterval = {4,8};

//        int[][] intervals = {{1,3}, {6,9}};
//        int[] newInterval = {2,5};

        InsertInterval insertInterval = new InsertInterval();
        int[][] result = insertInterval.insert(intervals, newInterval);
        System.out.println(result);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        boolean added = false;
        for (int i = 0; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            if (added || currInterval[1] < newInterval[0]) {
                // insert before interval
                res.add(currInterval);
            } else if (currInterval[0] > newInterval[1]) {
                // insert after interval
                res.add(newInterval);
                res.add(currInterval);
                added = true;
            } else {
                newInterval[0] = Math.min(newInterval[0], currInterval[0]);
                newInterval[1] = Math.max(newInterval[1], currInterval[1]);
            }
        }
        if (!added) {
            res.add(newInterval);
        }
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

}
