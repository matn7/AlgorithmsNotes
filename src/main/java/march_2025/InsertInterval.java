package march_2025;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
//        int[][] intervals = {{1, 3}, {6, 9}};
//        int[] newInterval = {2, 5};

        // intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]

        int[][] intervals = {{1,2}, {3,5}, {6,7}, {8,10}, {12,16}};
        int[] newInterval = {4, 8};

        InsertInterval insertInterval = new InsertInterval();
        int[][] result = insertInterval.insert(intervals, newInterval);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> temp = new ArrayList<>();
        boolean added = false;
        for (int i = 0; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (added || curr[1] < newInterval[0]) {
                temp.add(curr);
            } else if (curr[0] > newInterval[1]) {
                temp.add(newInterval);
                temp.add(curr);
                added = true;
            } else {
                newInterval[0] = Math.min(curr[0], newInterval[0]);
                newInterval[1] = Math.max(curr[1], newInterval[1]);
            }
        }
        if (!added) {
            temp.add(newInterval);
        }
        return temp.toArray(new int[temp.size()][]);
    }


}
