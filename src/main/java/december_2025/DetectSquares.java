package december_2025;

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

    Map<List<Integer>, Integer> freqMap;
    List<int[]> points;

    public DetectSquares() {
        freqMap = new HashMap<>();
        points = new ArrayList<>();
    }

    // O(1) time
    public void add(int[] point) {
        freqMap.put(List.of(point[0], point[1]), freqMap.getOrDefault(List.of(point[0], point[1]), 0) + 1);
        points.add(point);
    }

    // O(n) time | O(n) space
    public int count(int[] point) {
        int count = 0;

        for (int i = 0; i < points.size(); i++) {
            int px = point[0];
            int py = point[1];

            int[] currPoint = points.get(i);
            int px1 = currPoint[0];
            int py1 = currPoint[1];

            if (px1 == px || py1 == py || (Math.abs(py1 - py) != Math.abs(px1 - px))) {
                continue;
            }

            List<Integer> key1 = List.of(px, py1);
            List<Integer> key2 = List.of(px1, py);

            count += freqMap.getOrDefault(key1, 0) * freqMap.getOrDefault(key2, 0);
        }

        return count;
    }

}
