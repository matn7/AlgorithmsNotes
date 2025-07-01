package june_2025;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval2 {

    public static void main(String[] args) {
//        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
//        int[] newInterval = {4,8};

        int[][] intervals = {{2,5}, {6,7}, {8,9}};
        int[] newInterval = {0,1};

        InsertInterval2 insertInterval2 = new InsertInterval2();
        int[][] result = insertInterval2.insert(intervals, newInterval);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }
        List<int[]> result = new ArrayList<>();
        boolean inserted = false;
        for (int[] curr : intervals) {
            if (curr[1] < newInterval[0] || inserted) {
                result.add(curr);
            } else if (curr[0] > newInterval[1]) {
                result.add(newInterval);
                result.add(curr);
                inserted = true;
            } else {
                newInterval[0] = Math.min(curr[0], newInterval[0]);
                newInterval[1] = Math.max(curr[1], newInterval[1]);
            }
        }
        if (!inserted) {
            result.add(newInterval);
        }

        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

}
