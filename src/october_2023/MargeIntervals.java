package october_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MargeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {5, 8}, {4, 10}, {20, 25}};
        List<int[]> result = mergeIntervals(intervals);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public static List<int[]> mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // [[1, 3], [4, 10], [5, 8], [20, 25]]
        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {
            if (result.isEmpty()) {
                result.add(interval);
            } else {
                int[] current = result.get(result.size() - 1); // [4, 10]
                if (current[1] > interval[0]) { // 10 > 5
                    current[0] = Math.min(current[0], interval[0]);
                    current[1] = Math.max(current[1], interval[1]);
                } else {
                    result.add(interval);
                }
            }
        }


        return result;
    }

}
