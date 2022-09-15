package whiteboard;

import java.util.*;

public class RectangleMania {

    // O(n^2) time | O(n) space
    // rand: 16/08/2022
    public static int rectangleMania(List<Integer[]> coords) {
        // Write your code here.
        Map<String, Point> pointsMap = new HashMap<>();
        for (Integer[] coord : coords) {
            int x = coord[0];
            int y = coord[1];
            String key = x + "-" + y;
            pointsMap.put(key, new Point(x, y));
        }

        int counter = 0;
        for (int i = 0; i < coords.size(); i++) {
            Integer[] current = coords.get(i);
            for (int j = 0; j < coords.size(); j++) {
                Integer[] other = coords.get(j);
                if (!isUpperRight(current, other)) {
                    continue;
                }
                String key1 = current[0] + "-" + other[1];
                String key2 = other[0] + "-" + current[1];
                if (pointsMap.containsKey(key1) && pointsMap.containsKey(key2)) {
                    counter++;
                }
            }
        }

        return counter;
    }

    private static boolean isUpperRight(Integer[] c, Integer[] o) {
        int x1 = c[0];
        int y1 = c[1];
        int x2 = o[0];
        int y2 = o[1];
        return x2 > x1 && y2 > y1;
    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
