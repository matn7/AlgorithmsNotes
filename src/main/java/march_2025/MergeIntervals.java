package march_2025;

import java.util.ArrayList;
import java.util.Arrays;
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
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();

        for (int[] inter : intervals) {
            if (!list.isEmpty() && list.get(list.size() - 1)[1] >= inter[0]) {
                int[] curr = list.get(list.size() - 1);
                curr[1] = Math.max(curr[1], inter[1]);
            } else {
                list.add(inter);
            }
        }
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}
