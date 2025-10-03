package september_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] merge = mergeIntervals.merge(intervals);
        System.out.println(merge);
    }

    // O(nlog(n)) time | O(n) space
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();

        for (int[] interval : intervals) {
            if (res.isEmpty()) {
                res.add(interval);
            } else {
                int[] current = res.get(res.size() - 1);
                if (interval[0] <= current[1]) {
                    current[1] = Math.max(current[1], interval[1]);
                } else {
                    res.add(interval);
                }
            }
        }

        return res.toArray(new int[][] {});
    }

}
