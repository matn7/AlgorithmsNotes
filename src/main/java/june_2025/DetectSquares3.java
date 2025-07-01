package june_2025;

import java.util.*;

public class DetectSquares3 {

    public static void main(String[] args) {
        DetectSquares3 detectSquares3 = new DetectSquares3();
        detectSquares3.add(new int[] {3, 10});
        detectSquares3.add(new int[] {11, 2});
        detectSquares3.add(new int[] {3, 2});
        detectSquares3.add(new int[] {11, 2});
        System.out.println(detectSquares3.count(new int[] {11, 10}));
    }

    Map<List<Integer>, Integer> freq;
    List<int[]> points;

    public DetectSquares3() {
        freq = new HashMap<>();
        points = new ArrayList<>();
    }

    public void add(int[] point) {
        List<Integer> key = Arrays.asList(point[0], point[1]);
        freq.put(key, freq.getOrDefault(key, 0) + 1);
        points.add(point);
    }

    public int count(int[] point) {
        int res = 0;
        int x = point[0];
        int y = point[1];

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
