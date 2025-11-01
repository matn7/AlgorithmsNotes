package june_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectSquares {

    private Map<String, Integer> ptsCount;
    private List<int[]> points;

    public DetectSquares() {
        ptsCount = new HashMap<>();
        points = new ArrayList<>();
    }

    public void add(int[] point) {
        String key = point[0] + ":" + point[1];
        ptsCount.put(key, ptsCount.getOrDefault(key, 0) + 1);
        points.add(point);
    }

    public int count(int[] point) {
        int res = 0;
        int px = point[0];
        int py = point[1];

        for (int[] p : points) {
            int x = p[0];
            int y = p[1];

            if (x == px || y == py || Math.abs(x - px) != Math.abs(y - py)) {
                continue;
            }

            res += ptsCount.getOrDefault(x + ":" + py, 0) *
                    ptsCount.getOrDefault(px + ":" + y, 0);
        }
        return res;
    }

}
