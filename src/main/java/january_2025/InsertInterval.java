package january_2025;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        int[][] intervals = {{1,2}, {3,5}, {6,7}, {8,10}, {12,16}};

        InsertInterval insertInterval = new InsertInterval();
        int[][] result = insertInterval.insert(intervals, new int[]{4, 8});
        System.out.println(result);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        int idx = 0;

        while (idx < intervals.length && intervals[idx][1] < newInterval[0]) {
            result.add(intervals[idx]);
            idx++;
        }

        while (idx < intervals.length && intervals[idx][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[idx][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[idx][1], newInterval[1]);
            idx++;
        }
        result.add(newInterval);

        while (idx < intervals.length) {
            result.add(intervals[idx]);
            idx++;
        }

        return result.toArray(new int[result.size()][]);
    }

}
