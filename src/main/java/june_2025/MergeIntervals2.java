package june_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals2 {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        MergeIntervals2 mergeIntervals2 = new MergeIntervals2();
        int[][] result = mergeIntervals2.merge(intervals);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        for (int[] newInterval : intervals) {
            if (result.isEmpty()) {
                result.add(newInterval);
            } else {
                int[] curr = result.get(result.size() - 1);
                if (newInterval[0] <= curr[1]) {
                    curr[0] = Math.min(curr[0], newInterval[0]);
                    curr[1] = Math.max(curr[1], newInterval[1]);
                } else {
                    result.add(newInterval);
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
