package april_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] result = mergeIntervals.merge(intervals);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> resArr = new ArrayList<>();

        for (int[] interval : intervals) {
            if (resArr.isEmpty()) {
                resArr.add(interval);
            } else {
                int[] curr = resArr.get(resArr.size() - 1);
                if (curr[1] >= interval[0]) {
                    curr[1] = Math.max(curr[1], interval[1]);
                } else {
                    resArr.add(interval);
                }
            }
        }

        int[][] result = new int[resArr.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = resArr.get(i);
        }

        return result;
    }

}
