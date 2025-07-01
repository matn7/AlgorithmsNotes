package june_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval3 {

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};

        InsertInterval3 insertInterval3 = new InsertInterval3();
        int[][] result = insertInterval3.insert(intervals, newInterval);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public int[][] insert(int[][] intervals, int[] newInterval) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        boolean added = false;
        for (int[] curr : intervals) {
            if (added || curr[1] < newInterval[0]) {
                result.add(curr);
            } else if (curr[0] > newInterval[1]) {
                result.add(newInterval);
                result.add(curr);
                added = true;
            } else {
                newInterval[0] = Math.min(newInterval[0], curr[0]);
                newInterval[1] = Math.max(newInterval[1], curr[1]);
            }
        }
        if (!added) {
            result.add(newInterval);
        }
        return result.toArray(new int[][] {});
    }

}
