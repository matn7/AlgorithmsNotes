package whiteboard;

import java.util.*;

public class RectangleMania {

    // ********
    // * STAR - G *
    // ********

    // O(n^2) time | O(n) space
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

    // O(n^2) time | O(n) space
    public static int rectangleMania2(List<Integer[]> coords) {
        Map<String, Boolean> coordsTable = getCoordsTable(coords);
        return getRectangleCount(coords, coordsTable);
    }

    private static Map<String, Boolean> getCoordsTable(List<Integer[]> coords) {
        Map<String, Boolean> coordsTable = new HashMap<>();
        for (Integer[] coord : coords) {
            String coordString = coordToString(coord);
            coordsTable.put(coordString, Boolean.TRUE);
        }
        return coordsTable;
    }

    private static int getRectangleCount(List<Integer[]> coords, Map<String, Boolean> coordsTable) {
        int rectangleCount = 0;
        for (int i = 0; i < coords.size(); i++) {
            Integer x1 = coords.get(i)[0];
            Integer y1 = coords.get(i)[1];
            for (int j = 0; j < coords.size(); j++) {
                Integer x2 = coords.get(j)[0];
                Integer y2 = coords.get(j)[1];
                if (!isInUpperRight(coords.get(i), coords.get(j))) {
                    continue;
                }
                String upperCoordsString = coordToString(new Integer[]{x1, y2});
                String rightCoordString  = coordToString(new Integer[]{x2, y1});

                if (coordsTable.containsKey(upperCoordsString) && coordsTable.containsKey(rightCoordString)) {
                    rectangleCount++;
                }
            }
        }
        return rectangleCount;
    }

    private static boolean isInUpperRight(Integer[] coord1, Integer[] coord2) {
        int x1 = coord1[0];
        int y1 = coord1[1];
        int x2 = coord2[0];
        int y2 = coord2[1];
        return x2 > x1 && y2 > y1;
    }

    private static String coordToString(Integer[] coord) {
        return coord[0] + "-" + coord[1];
    }

}
