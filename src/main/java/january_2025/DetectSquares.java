package january_2025;

import java.util.*;

public class DetectSquares {

    private Map<List<Integer>, Integer> ptsCount;
    List<List<Integer>> pts;

    public DetectSquares() {
        ptsCount = new HashMap<>();
        pts = new ArrayList<>();
    }

    public void add(int[] point) {
        List<Integer> p = Arrays.asList(point[0], point[1]);
        ptsCount.put(p, ptsCount.getOrDefault(p, 0) + 1);
        pts.add(p);
    }

    public int count(int[] point) {
        int res = 0;
        int px = point[0];
        int py = point[1];

        for (List<Integer> p : pts) {
            int x = p.get(0);
            int y = p.get(1);
            if (Math.abs(py - y) != Math.abs(px - x) || x == px || y == py) {
                continue;
            }
            res += ptsCount.getOrDefault(Arrays.asList(x, py), 0) * ptsCount.getOrDefault(Arrays.asList(px, y), 0);
        }
        return res;
    }

}
