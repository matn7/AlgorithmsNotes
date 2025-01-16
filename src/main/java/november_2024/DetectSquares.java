package november_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectSquares {

    Map<String, Integer> ptsCount;
    List<int[]> pts;
    public DetectSquares() {
        ptsCount = new HashMap<>();
        pts = new ArrayList<>();
    }

    public void add(int[] point) {
        String key = getKey(point);
        ptsCount.put(key, ptsCount.getOrDefault(key, 0) + 1);
        pts.add(point);
    }

    public int count(int[] point) {
        int res = 0;
        int px = point[0];
        int py = point[1];
        for (int[] p : pts) {
            int x = p[0];
            int y = p[1];
            if (Math.abs(py - y) != Math.abs(px - x) || x == px || y == py) {
                continue;
            }
            String key1 = getKey(new int[] {x, py});
            String key2 = getKey(new int[] {px, y});
            res += ptsCount.getOrDefault(key1, 0) * ptsCount.getOrDefault(key2, 0);
        }

        return res;
    }

    private String getKey(int[] point) {
        return point[0] + ":" + point[1];
    }

}
