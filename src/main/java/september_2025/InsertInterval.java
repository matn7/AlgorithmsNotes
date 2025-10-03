package september_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};

        InsertInterval insertInterval = new InsertInterval();
        int[][] insert = insertInterval.insert(intervals, newInterval);
        System.out.println(insert);

    }

    // O(nlog(n)) time | O(n) space
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();
        boolean added = false;
        for (int[] curr : intervals) {
            if (curr[1] < newInterval[0] || added) {
                res.add(curr);
            } else if (curr[0] > newInterval[1]) {
                res.add(newInterval);
                res.add(curr);
                added = true;
            } else {
                newInterval[0] = Math.min(newInterval[0], curr[0]);
                newInterval[1] = Math.max(newInterval[1], curr[1]);
            }
        }
        if (!added) {
            res.add(newInterval);
        }
        return res.toArray(new int[][] {});
    }

}
