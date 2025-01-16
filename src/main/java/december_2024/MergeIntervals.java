package december_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        // intervals = [[1,3],[2,6],[8,10],[15,18]]
        int[][] intervals = {{1,3}, {2, 6}, {8, 10}, {15,18}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] result = mergeIntervals.merge(intervals);
        System.out.println(result);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merge = new ArrayList<>();
        //                              *
        // intervals = [[1,3],[2,6],[8,10],[15,18]]
        // [1, 6]
        for (int[] interval : intervals) {
            if (merge.isEmpty()) {
                merge.add(interval);
            } else {
                int[] curr = merge.get(merge.size() - 1); // [1, 6]
                if (curr[1] >= interval[0]) { // 6 >= 8
                    curr[1] = Math.max(curr[1], interval[1]);
                } else {
                    merge.add(interval);
                }
            }
        }
        int[][] res = new int[merge.size()][2];
        for (int i = 0; i < merge.size(); i++) {
            res[i] = merge.get(i);
        }
        return res;
    }


}
