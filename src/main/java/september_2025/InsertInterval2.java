package september_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval2 {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};

        InsertInterval2 insertInterval2 = new InsertInterval2();
        int[][] result = insertInterval2.insert(intervals, newInterval);
        System.out.println(result);

    }

    // O(nlog(n)) time | O(n) space
    // O(n) time | O(n) space - without sorting
    public int[][] insert(int[][] intervals, int[] newInterval) {
        boolean added = false;
//        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0] || added) {
                result.add(interval);
            } else if (interval[0] > newInterval[1]) {
                result.add(newInterval);
                result.add(interval);
                added = true;
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        if (!added) {
            result.add(newInterval);
        }

        return result.toArray(new int[][] {});
    }

}
