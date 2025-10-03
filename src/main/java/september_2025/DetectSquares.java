package september_2025;

import java.util.*;

public class DetectSquares {

    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[] {3, 10});
        detectSquares.add(new int[] {11, 2});
        detectSquares.add(new int[] {3, 2});

        int count = detectSquares.count(new int[]{11, 10});
        System.out.println(count);

        int count1 = detectSquares.count(new int[]{14, 8});
        System.out.println(count1);

        detectSquares.add(new int[] {11, 2});

        int count2 = detectSquares.count(new int[]{11, 10});
        System.out.println(count2);
    }

    Map<List<Integer>, Integer> countsMap;
    List<int[]> points;
    public DetectSquares() {
        countsMap = new HashMap<>();
        points = new ArrayList<>();
    }

    // O(1) time
    public void add(int[] point) {
        countsMap.put(Arrays.asList(point[0], point[1]), countsMap.getOrDefault(Arrays.asList(point[0], point[1]), 0) + 1);
        points.add(point);
    }

    // O(n) time | O(n) space
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

            res += countsMap.getOrDefault(Arrays.asList(x, py), 0) * countsMap.getOrDefault(Arrays.asList(px, y), 0);
        }

        return res;
    }

}
