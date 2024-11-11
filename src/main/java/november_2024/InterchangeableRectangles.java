package november_2024;

import java.util.HashMap;
import java.util.Map;

public class InterchangeableRectangles {

    public static void main(String[] args) {
        int[][] rectangles = {{4,8}, {3,6}, {10,20}, {15,30}};

        InterchangeableRectangles interchangeableRectangles = new InterchangeableRectangles();
        long result = interchangeableRectangles.interchangeableRectangles(rectangles);
        System.out.println(result);
    }

    public long interchangeableRectangles(int[][] rectangles) {
        long res = 0;

        Map<Double, Integer> count = new HashMap<>();

        for (int[] rect : rectangles) {
            int w = rect[0];
            int h = rect[1];
            double ratio = 1.0 * w / h;
            count.put(ratio, count.getOrDefault(ratio, 0) + 1);
        }

        for (Map.Entry<Double, Integer> elem : count.entrySet()) {
            int c = elem.getValue();
            if (c > 1) {
                res += ((long) c * (c - 1)) / 2;
            }
        }

        return res;
    }

}
