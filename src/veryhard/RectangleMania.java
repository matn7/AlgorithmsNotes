package veryhard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RectangleMania {

    public static void main(String[] args) {
        List<Integer[]> coords = new ArrayList<>();
        Integer[] coord1 = {0, 1};
        Integer[] coord2 = {1, 1};
        Integer[] coord3 = {2, 1};
        Integer[] coord4 = {0, 0};
        Integer[] coord5 = {1, 0};
        Integer[] coord6 = {2, 0};

        coords.add(coord1);
        coords.add(coord2);
        coords.add(coord3);
        coords.add(coord4);
        coords.add(coord5);
        coords.add(coord6);

        rectangleMania(coords);
    }

    // O(n^2) time | O(n) space
    public static int rectangleMania(List<Integer[]> coords) {
        // Write your code here.
        Map<String, Boolean> coordsTable = getCoordsTable(coords);
        return getRectangleCount(coords, coordsTable);
    }

    private static int getRectangleCount(List<Integer[]> coords, Map<String, Boolean> coordsTable) {
        int rectangleCount = 0;
        for (Integer[] coord1 : coords) {
            int x1 = coord1[0];
            int y1 = coord1[1];
            for (Integer[] coord2 : coords) {
                int x2 = coord2[0];
                int y2 = coord2[1];
                if (!isInUpperRight(coord1, coord2)) {
                    continue;
                }
                Integer[] upper = {x1, y2};
                String upperCoordString = coordToString(upper);
                Integer[] right = {x2, y1};
                String rightCoordString = coordToString(right);

                if (coordsTable.containsKey(upperCoordString) && coordsTable.containsKey(rightCoordString)) {
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


    private static Map<String, Boolean> getCoordsTable(List<Integer[]> coords) {
        Map<String, Boolean> coordsTable = new HashMap<>();
        for (Integer[] coord : coords) {
            String coordString = coordToString(coord);
            coordsTable.put(coordString, Boolean.TRUE);
        }
        return coordsTable;
    }

    private static String coordToString(Integer[] coord) {
        int x = coord[0];
        int y = coord[1];
        return x + "-" + y;
    }

//    // O(n^2) time | O(n) space
//    public static int rectangleMania(List<Integer[]> coords) {
//        // Write your code here.
//        Map<String, Map<Integer, List<Integer[]>>> coordsTable = getCoordsTable(coords);
//        return getRectangleCount(coords, coordsTable);
//    }
//
//    private static Map<String, Map<Integer, List<Integer[]>>> getCoordsTable(List<Integer[]> coords) {
//        Map<String, Map<Integer, List<Integer[]>>> coordsTable = new HashMap<>();
//        coordsTable.put("x", new HashMap<>());
//        coordsTable.put("y", new HashMap<>());
//        for (Integer[] coord : coords) {
//            int x = coord[0];
//            int y = coord[1];
//            if (!coordsTable.get("x").containsKey(x)) {
//                coordsTable.get("x").put(x, new ArrayList<>());
//            }
//            List<Integer[]> xList = coordsTable.get("x").get(x);
//            xList.add(coord);
//            coordsTable.get("x").put(x, xList);
//
//            if (!coordsTable.get("y").containsKey(y)) {
//                coordsTable.get("y").put(y, new ArrayList<>());
//            }
//            List<Integer[]> yList = coordsTable.get("y").get(y);
//            yList.add(coord);
//            coordsTable.get("y").put(y, yList);
//        }
//        return coordsTable;
//    }
//
//    private static int getRectangleCount(List<Integer[]> coords, Map<String, Map<Integer, List<Integer[]>>> coordsTable) {
//        int rectangleCount = 0;
//        for (Integer[] coord : coords) {
//            Integer lowerLeftY = coord[1];
//            rectangleCount += clockwiseCountRectangles(coord, coordsTable, "up", lowerLeftY);
//        }
//
//        return rectangleCount;
//    }
//
//    private static int clockwiseCountRectangles(Integer[] coord1, Map<String, Map<Integer, List<Integer[]>>> coordsTable,
//                                                String direction, Integer lowerLeftY) {
//        int x1 = coord1[0];
//        int y1 = coord1[1];
//
//        if (direction.equals("down")) {
//            List<Integer[]> relevantCoords = coordsTable.get("x").get(x1);
//            for (Integer[] coord2 : relevantCoords) {
//                Integer lowerRightY = coord2[1];
//                if (lowerRightY == lowerLeftY) {
//                    return 1;
//                }
//            }
//            return 0;
//        } else {
//            int rectangleCount = 0;
//            if (direction.equals("up")) {
//                List<Integer[]> relevantCoords = coordsTable.get("x").get(x1);
//                for (Integer[] coord2 : relevantCoords) {
//                    int y2 = coord2[1];
//                    boolean isAbove = y2 > y1;
//                    if (isAbove) {
//                        rectangleCount += clockwiseCountRectangles(coord2, coordsTable, "right", lowerLeftY);
//                    }
//                }
//            } else if (direction.equals("right")) {
//                List<Integer[]> relevantCoords = coordsTable.get("y").get(y1);
//                for (Integer[] coord2 : relevantCoords) {
//                    int x2 = coord2[1];
//                    boolean isRight = x2 > x1;
//                    if (isRight) {
//                        rectangleCount += clockwiseCountRectangles(coord2, coordsTable, "down", lowerLeftY);
//                    }
//                }
//            }
//            return rectangleCount;
//        }
//    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
