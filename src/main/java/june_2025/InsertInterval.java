package june_2025;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    // O(n) time | O(n) space
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // c[0]         c[1]    n[0]    n[1]    c[0]    c[1]
        // -+------------+-------+--------+-------+-------+----
        List<int[]> res = new ArrayList<>();
        boolean added = false;
        for (int[] curr : intervals) {
            if (added || curr[1] < newInterval[0]) {
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
        return res.toArray(new int[res.size()][]);
    }

}
