package january_2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {

    public static void main(String[] args) {
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};

        IntervalListIntersections intervalListIntersections = new IntervalListIntersections();
        int[][] result = intervalListIntersections.intervalIntersection(firstList, secondList);
        System.out.println(result);
    }

    // O((n + m)log(n + m)) time | O(m + n) space
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> lists = new ArrayList<>(Arrays.asList(firstList));
        lists.addAll(Arrays.asList(secondList));

        lists.sort((a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        merged.add(lists.get(0));
        List<int[]> common = new ArrayList<>();

        for (int i = 1; i < lists.size(); i++) {
            int[] currentInterval = merged.get(merged.size() - 1);
            int[] newInterval = lists.get(i);

            if (currentInterval[1] >= newInterval[0]) {
                common.add(new int[] {Math.max(currentInterval[0], newInterval[0]), Math.min(currentInterval[1], newInterval[1])});
                currentInterval[0] = Math.min(currentInterval[0], newInterval[0]);
                currentInterval[1] = Math.max(currentInterval[1], newInterval[1]);
            } else {
                merged.add(newInterval);
            }
        }
        int[][] result = new int[common.size()][2];
        for (int i = 0; i < common.size(); i++) {
            result[i] = common.get(i);
        }

        return result;
    }

}
