package november_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] merge = mergeIntervals.merge(intervals);
        System.out.println(merge);
    }

    // O(nlog(n)) time | O(n) space
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {
            if (result.isEmpty()) {
                result.add(interval);
            } else {
                int[] curr = result.get(result.size() - 1);
                if (curr[1] >= interval[0]) {
                    curr[1] = Math.max(curr[1], interval[1]);
                } else {
                    result.add(interval);
                }
            }
        }
        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

}
