package june_2025;

import java.util.*;

public class DetectSquares2 {

    Map<List<Integer>, Integer> freq;
    List<int[]> points;

    public DetectSquares2() {
        freq = new HashMap<>();
        points = new ArrayList<>();
    }

    // O(1) time | O(1) space
    public void add(int[] point) {
        List<Integer> p = Arrays.asList(point[0], point[1]);
        freq.put(p, freq.getOrDefault(p, 0) + 1);
        points.add(point);
    }

    // O(n) time | O(1) space
    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int res = 0;

        for (int[] p : points) {
            int px = p[0];
            int py = p[1];

            if (Math.abs(x - px) != Math.abs(y - py) || x == px || y == py) {
                continue;
            }

            res += freq.getOrDefault(Arrays.asList(x, py), 0) * freq.getOrDefault(Arrays.asList(px, y), 0);
        }
        return res;
    }

}
