package july_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};

        InsertInterval insertInterval = new InsertInterval();
        int[][] result = insertInterval.insert(intervals, newInterval);
        System.out.println(result);
    }

    // Intuition:
    // - Sort intervals, keep building new res arr
    // - what overlap means? [0, 2], [2, 4] overlap -> yes -> [0, 4]
    // Approach:
    // - sort
    // - keep updating newInterval
    // -- [newInterval, curr ] -> newInterval[1] < curr[0] -> add new Interval, curr, added flag
    // -- [curr, newInterval ] -> curr[1] < newInterval[0] -> add curr
    // - remember about base and corner cases
    // Complexity:
    // O(nlog(n)) time | O(n) space -> sorting quick sort
    // O(n) time | O(n) space -> build result arrays
    // O(nlog(n)) time | O(n) space
    // Code:

    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        boolean added = false;
        for (int[] curr : intervals) {
            if (added || curr[1] < newInterval[0]) {
                result.add(curr);
            } else if (newInterval[1] < curr[0]) {
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
