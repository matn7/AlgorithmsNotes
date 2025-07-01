package june_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2,6}, {8,10}, {15,18}};

        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] merge = mergeIntervals.merge(intervals);
        System.out.println(merge);
    }

    // O(n log(n)) time | O(n) space
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();

        for (int[] interval : intervals) {
            if (res.isEmpty()) {
                res.add(interval);
            } else {
                int[] curr = res.get(res.size() - 1);
                if (curr[1] >= interval[0]) {
                    curr[0] = Math.min(curr[0], interval[0]);
                    curr[1] = Math.max(curr[1], interval[1]);
                } else {
                    res.add(interval);
                }
            }
        }

        return res.toArray(new int[res.size()][]);
    }

}
