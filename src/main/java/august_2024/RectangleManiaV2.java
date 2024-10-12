package august_2024;

import java.util.HashMap;
import java.util.Map;

public class RectangleManiaV2 {

    public static void main(String[] args) {
        int[][] coords = {{0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 1}, {3, 0}, {3, 1}};

        int result = countRectangles(coords);
        System.out.println(result);
    }

    // O(n^2) time | O(n) space
    public static int countRectangles(int[][] coords) {
        Map<String, Boolean> coordsMap = new HashMap<>();
        for (int[] coord : coords) {
            String key = getKey(coord);
            coordsMap.put(key, Boolean.TRUE);
        }

        int count = 0;
        for (int i = 0; i < coords.length; i++) {
            int[] current = coords[i];
            for (int j = 0; j < coords.length; j++) {
                int[] other = coords[j];
                if (!isUpperRight(current, other)) {
                    continue;
                }
                String key1 = getKey(new int[] {current[0], other[1]});
                String key2 = getKey(new int[] {other[0], current[1]});

                if (coordsMap.containsKey(key1) && coordsMap.containsKey(key2)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isUpperRight(int[] coord1, int[] coord2) {
        int x1 = coord1[0];
        int y1 = coord1[1];
        int x2 = coord2[0];
        int y2 = coord2[1];
        return x2 > x1 && y2 > y1;
    }

    private static String getKey(int[] coord) {
        return coord[0] + ":" + coord[1];
    }

}
