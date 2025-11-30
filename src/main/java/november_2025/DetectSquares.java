package november_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectSquares {

    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[] {3, 10});
        detectSquares.add(new int[] {11, 2});
        detectSquares.add(new int[] {3, 2});
        System.out.println(detectSquares.count(new int[] {11, 10}));
        System.out.println(detectSquares.count(new int[] {14, 8}));
        detectSquares.add(new int[] {11, 2});
        System.out.println(detectSquares.count(new int[] {11, 10}));
    }

    // O(n) time | O(n) space
    List<int[]> points;
    Map<String, Integer> pointsMap;

    public DetectSquares() {
        points = new ArrayList<>();
        pointsMap = new HashMap<>();
    }

    public void add(int[] point) {
        points.add(point);
        String key = point[0] + ":" + point[1];
        pointsMap.put(key, pointsMap.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {
        int count = 0;
        for (int[] p : points) {
            int px = point[0];
            int py = point[1];

            int px1 = p[0];
            int py1 = p[1];

            if (Math.abs(py - py1) != Math.abs(px - px1) ||  px == px1 || py == py1) {
                continue;
            }

            String key1 = px1 + ":" + py;
            String key2 = px + ":" + py1;

            count += pointsMap.getOrDefault(key1, 0) * pointsMap.getOrDefault(key2, 0);
        }
        return count;
    }

}
