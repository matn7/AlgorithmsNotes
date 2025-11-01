package october_2025;

import java.util.*;

public class DetectSquares {

    // O(n) time | O(n) space
    List<int[]> points;
    Map<List<Integer>, Integer> freq;

    public DetectSquares() {
        points = new ArrayList<>();
        freq = new HashMap<>();
    }

    public void add(int[] point) {
        points.add(point);
        freq.put(Arrays.asList(point[0], point[1]), freq.getOrDefault(Arrays.asList(point[0], point[1]), 0) + 1);
    }

    public int count(int[] point) {
        int result = 0;
        int px = point[0];
        int py = point[1];
        for (int[] p : points) {
            int x = p[0];
            int y = p[1];

            if (Math.abs(px - x) != Math.abs(py - y) || x == px || y == py) {
                continue;
            }
            result += freq.getOrDefault(Arrays.asList(x, py), 0) *
                    freq.getOrDefault(Arrays.asList(px, y), 0);
        }
        return result;
    }


}
