package july_2025;

import java.util.*;

public class DetectSquares {

    // Intuition:
    // - how to detect square? len of side is the same
    // - how to detect squares coords (x,y) - on diagonal
    // Approach:
    // - add all points to List<int[]>
    // - add freq of points
    // - loop through to count res
    // Complexity:
    // - O(n) time | O(n) space
    // Code:

    Map<List<Integer>, Integer> pointsFreq;
    List<int[]> points;

    public DetectSquares() {
        pointsFreq = new HashMap<>();
        points = new ArrayList<>();
    }

    public void add(int[] point) {
        List<Integer> key = Arrays.asList(point[0], point[1]);
        pointsFreq.put(key, pointsFreq.getOrDefault(key, 0) + 1);
        points.add(point);
    }

    public int count(int[] point) {
        int res = 0;
        int x = point[0];
        int y = point[1];

        for (int[] pt : points) {
            int px = pt[0];
            int py = pt[1];

            if (Math.abs(x - px) != Math.abs(y - py) || px == x || py == y) {
                continue;
            }

            res += pointsFreq.getOrDefault(Arrays.asList(x, py), 0)
                    * pointsFreq.getOrDefault(Arrays.asList(px, y), 0);
        }
        return res;
    }

}
