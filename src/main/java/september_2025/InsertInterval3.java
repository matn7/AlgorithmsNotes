package september_2025;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval3 {

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};

        InsertInterval3 insertInterval3 = new InsertInterval3();
        int[][] result = insertInterval3.insert(intervals, newInterval);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resArr = new ArrayList<>();
        boolean added = false;
        //
        // [newInterval] [curr]

        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0] || added) {
                resArr.add(interval);
            } else if (interval[0] > newInterval[1]) {
                resArr.add(newInterval);
                resArr.add(interval);
                added = true;
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        if (!added) {
            resArr.add(newInterval);
        }
        return resArr.toArray(new int[][] {});
    }

}
