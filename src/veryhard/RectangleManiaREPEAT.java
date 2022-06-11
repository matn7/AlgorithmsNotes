package veryhard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RectangleManiaREPEAT {

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

        int result = rectangleMania(coords);
        System.out.println(result);
    }
    //          |
    //          +
    //       P2 |   P3  P5  P7
    //          *   *   *   *
    //          |
    //  --------*---*---*---*---+--------
    //       P1 |   P4  P6  P8

    // OK - repeated 19/02/2022
    // O(n^2) time | O(n) space
    public static int rectangleMania(List<Integer[]> coords) {
        // Write your code here.
        //    P1    P2    P3    P4    P5    P6    P7    P8
        // [[0,0],[0,1],[1,1],[1,0],[2,1],[2,0],[3,1],[3,0]]
        List<Point> coordPoints = new ArrayList<>();
        for (Integer[] element : coords) {
            coordPoints.add(new Point(element[0], element[1]));
        }
        //                                                      *
        // coordPoints = [(0,0),(0,1),(1,1),(1,0),(2,1),(2,0),(3,1),(3,0)]
        Map<String, Boolean> coordsTable = getCoordsTable(coordPoints);
        // coordsTable = {"0-0":TRUE, "0-1":TRUE, "1-1":TRUE, "1-0":TRUE, "2-1":TRUE, "2-0":TRUE, "3-1":TRUE, "3-0":TRUE}
        return getRectangleCount(coordPoints, coordsTable);
    }

    private static Map<String, Boolean> getCoordsTable(List<Point> coords) {
        Map<String, Boolean> coordsTable = new HashMap<>();
        // coordsTable = {"0-0":TRUE, "0-1":TRUE, "1-1":TRUE, "1-0":TRUE, "2-1":TRUE, "2-0":TRUE, "3-1":TRUE, "3-0":TRUE}
        for (Point coord : coords) { //(0,1)
            String coordString = coordToString(coord); // 0-1
            coordsTable.put(coordString, Boolean.TRUE);
        }
        return coordsTable;
    }

    // rec([(0,0),(0,1),(1,1),(1,0),(2,1),(2,0),(3,1),(3,0)],
    //   {"0-0":TRUE, "0-1":TRUE, "1-1":TRUE, "1-0":TRUE, "2-1":TRUE, "2-0":TRUE, "3-1":TRUE, "3-0":TRUE})
    private static int getRectangleCount(List<Point> coords, Map<String, Boolean> coordsTable) {
        //                                  c1
        // [(0,0),(0,1),(1,1),(1,0),(2,1),(2,0),(3,1),(3,0)]
        //                                        c2
        //
        // {"0-0":TRUE, "0-1":TRUE, "1-1":TRUE, "1-0":TRUE, "2-1":TRUE, "2-0":TRUE, "3-1":TRUE, "3-0":TRUE}
        //
        int rectangleCount = 0;
        for (Point coord1 : coords) { // (2,0)
            int x1 = coord1.x; // 2
            int y1 = coord1.y; // 0
            for (Point coord2 : coords) { // (3,1)
                int x2 = coord2.x; // 3
                int y2 = coord2.y; // 1
                // rec((1,0),(2,1))
                if (!isUpperRight(coord1, coord2)) {
                    continue;
                }
                String upperCoordString = coordToString(new Point(x1, y2)); // 2-1
                String rightCoordString = coordToString(new Point(x2, y1)); // 3-0
                if (coordsTable.containsKey(upperCoordString)
                        && coordsTable.containsKey(rightCoordString)) { // TRUE && TRUE
                    rectangleCount++; // 6
                }
            }
        }
        return rectangleCount;
    }

    // rec((2,0),(3,1))
    private static boolean isUpperRight(Point coord1, Point coord2) {
        int x1 = coord1.x; // 2
        int y1 = coord1.y; // 0
        int x2 = coord2.x; // 3
        int y2 = coord2.y; // 1
        return x2 > x1 && y2 > y1;
    }


    private static String coordToString(Point coord) {
        int x = coord.x;
        int y = coord.y;
        return x + "-" + y;
    }

//    // O(n^2) time | O(n) space
//    public static int rectangleMania(List<Integer[]> coords) {
//        // Write your code here.
//        List<Point> coordPoints = new ArrayList<>();
//        for (Integer[] element : coords) {
//            coordPoints.add(new Point(element[0], element[1]));
//        }
//        Map<String, Map<Integer, List<Point>>> coordsTable = getCoordsTable(coordPoints);
//        return getRectangleCount(coordPoints, coordsTable);
//    }
//
//    private static Map<String, Map<Integer, List<Point>>> getCoordsTable(List<Point> coords) {
//        Map<String, Map<Integer, List<Point>>> coordsTable = new HashMap<>();
//        coordsTable.put("x", new HashMap<>());
//        coordsTable.put("y", new HashMap<>());
//        for (Point coord : coords) {
//            int x = coord.x;
//            int y = coord.y;
//            if (!coordsTable.get("x").containsKey(x)) {
//                coordsTable.get("x").put(x, new ArrayList<>());
//            }
//            coordsTable.get("x").get(x).add(coord);
//            if (!coordsTable.get("y").containsKey(y)) {
//                coordsTable.get("y").put(y, new ArrayList<>());
//            }
//            coordsTable.get("y").get(y).add(coord);
//        }
//        return coordsTable;
//    }
//
//    private static int getRectangleCount(List<Point> coords,
//                                         Map<String, Map<Integer, List<Point>>> coordsTable) {
//        int rectangleCount = 0;
//        for (Point coord : coords) {
//            int lowerLeftY = coord.y;
//            rectangleCount += clockwiseCountRectangle(coord, coordsTable, "up", lowerLeftY);
//        }
//        return rectangleCount;
//    }
//
//    private static int clockwiseCountRectangle(Point coord1, Map<String, Map<Integer, List<Point>>> coordsTable,
//                                               String direction, int lowerLeftY) {
//        int x1 = coord1.x;
//        int y1 = coord1.y;
//        if (direction.equals("down")) {
//            List<Point> relevantCoords = coordsTable.get("x").get(x1);
//            for (Point coord2 : relevantCoords) {
//                int lowerRightY = coord2.y;
//                if (lowerRightY == lowerLeftY) {
//                    return 1;
//                }
//            }
//            return 0;
//        } else {
//            int rectangleCount = 0;
//            if (direction.equals("up")) {
//                List<Point> relevantCoords = coordsTable.get("x").get(x1);
//                for (Point coord2 : relevantCoords) {
//                    int y2 = coord2.y;
//                    boolean isAbove = y2 > y1;
//                    if (isAbove) {
//                        rectangleCount += clockwiseCountRectangle(coord2, coordsTable, "right", lowerLeftY);
//                    }
//                }
//            } else if (direction.equals("right")) {
//                List<Point> relevantCoords = coordsTable.get("y").get(y1);
//                for (Point coord2 : relevantCoords) {
//                    int x2 = coord2.x; // todo
//                    boolean isRight = x2 > x1;
//                    if (isRight) {
//                        rectangleCount += clockwiseCountRectangle(coord2, coordsTable, "down", lowerLeftY);
//                    }
//                }
//            }
//            return rectangleCount;
//
//        }
//    }

//    // O(n^2) time | O(n) space
//    public static int rectangleMania(List<Integer[]> coords) {
//        // Write your code here.
//        List<Point> coordPoints = new ArrayList<>();
//        for (Integer[] element : coords) {
//            coordPoints.add(new Point(element[0], element[1]));
//        }
//        Map<String, Map<Integer, List<Point>>> coordsTable = getCoordsTable(coordPoints);
//        return getRectangleCount(coordPoints, coordsTable);
//    }
//
//    private static Map<String, Map<Integer, List<Point>>> getCoordsTable(List<Point> coords) {
//        Map<String, Map<Integer, List<Point>>> coordsTable = new HashMap<>();
//        coordsTable.put("x", new HashMap<>());
//        coordsTable.put("y", new HashMap<>());
//        for (Point coord : coords) {
//            int x = coord.x;
//            int y = coord.y;
//            if (!coordsTable.get("x").containsKey(x)) {
//                coordsTable.get("x").put(x, new ArrayList<>());
//            }
//            coordsTable.get("x").get(x).add(coord);
//            if (!coordsTable.get("y").containsKey(y)) {
//                coordsTable.get("y").put(y, new ArrayList<>());
//            }
//            coordsTable.get("y").get(y).add(coord);
//        }
//        return coordsTable;
//    }
//
//    private static int getRectangleCount(List<Point> coords,
//                                         Map<String, Map<Integer, List<Point>>> coordsTable) {
//        int rectangleCount = 0;
//        for (Point coord : coords) {
//            int lowerLeftY = coord.y;
//            rectangleCount += clockwiseCountRectangle(coord, coordsTable, "up", lowerLeftY);
//        }
//        return rectangleCount;
//    }
//
//    private static int clockwiseCountRectangle(Point coord1, Map<String, Map<Integer, List<Point>>> coordsTable,
//                                               String direction, int lowerLeftY) {
//        int x1 = coord1.x;
//        int y1 = coord1.y;
//        if (direction.equals("down")) {
//            List<Point> relevantCoords = coordsTable.get("x").get(x1);
//            for (Point coord2 : relevantCoords) {
//                int lowerRightY = coord2.y;
//                if (lowerRightY == lowerLeftY) {
//                    return 1;
//                }
//            }
//            return 0;
//        } else {
//            int rectangleCount = 0;
//            if (direction.equals("up")) {
//                List<Point> relevantCoords = coordsTable.get("x").get(x1);
//                for (Point coord2 : relevantCoords) {
//                    int y2 = coord2.y;
//                    boolean isAbove = y2 > y1;
//                    if (isAbove) {
//                        rectangleCount += clockwiseCountRectangle(coord2, coordsTable, "right", lowerLeftY);
//                    }
//                }
//            } else if (direction.equals("right")) {
//                List<Point> relevantCoords = coordsTable.get("y").get(y1);
//                for (Point coord2 : relevantCoords) {
//                    int x2 = coord2.x; // todo
//                    boolean isRight = x2 > x1;
//                    if (isRight) {
//                        rectangleCount += clockwiseCountRectangle(coord2, coordsTable, "down", lowerLeftY);
//                    }
//                }
//            }
//            return rectangleCount;
//
//        }
//    }


//    // O(n^2) time | O(n^2) space
//    public static int rectangleMania(List<Integer[]> coords) {
//        // Write your code here.
//        List<Point> coordPoints = new ArrayList<>();
//        for (Integer[] element : coords) {
//            coordPoints.add(new Point(element[0], element[1]));
//        }
//        Map<String, Map<String, List<Point>>> coordsTable = getCoordsTable(coordPoints);
//        return getRectangleCount(coordPoints, coordsTable);
//    }
//
//    private static  Map<String, Map<String, List<Point>>> getCoordsTable(List<Point> coords) {
//        Map<String, Map<String, List<Point>>> coordsTable = new HashMap<>();
//
//        for (Point coord1 : coords) {
//            Map<String, List<Point>> coord1Directions = new HashMap<>();
//            coord1Directions.put("up", new ArrayList<>());
//            coord1Directions.put("right", new ArrayList<>());
//            coord1Directions.put("down", new ArrayList<>());
//            coord1Directions.put("left", new ArrayList<>());
//
//            for (Point coord2 : coords) {
//                String coord2Direction = getCoordDirection(coord1, coord2);
//                if (coord1Directions.containsKey(coord2Direction)) {
//                    coord1Directions.get(coord2Direction).add(coord2);
//                }
//            }
//            String coord1String = coordToString(coord1);
//            coordsTable.put(coord1String, coord1Directions);
//        }
//        return coordsTable;
//    }
//
//    private static String getCoordDirection(Point coord1, Point coord2) {
//        int x1 = coord1.x;
//        int y1 = coord1.y;
//        int x2 = coord2.x;
//        int y2 = coord2.y;
//        if (y2 == y1) {
//            if (x2 > x1) {
//                return "right";
//            } else if (x2 < x1) {
//                return "left";
//            }
//        } else if (x2 == x1) {
//            if (y2 > y1) {
//                return "up";
//            } else if (y2 < y1) {
//                return "down";
//            }
//        }
//        return "";
//    }
//
//    private static int getRectangleCount(List<Point> coords, Map<String, Map<String, List<Point>>> coordsTable) {
//        int rectangleCount = 0;
//        for (Point coord : coords) {
//            rectangleCount += clockwiseCountRectangles(coord, coordsTable, "up", coord);
//        }
//        return rectangleCount;
//    }
//
//    private static int clockwiseCountRectangles(Point coord,
//                                                Map<String, Map<String, List<Point>>> coordsTable,
//                                                String direction, Point origin) {
//        String coordString = coordToString(coord);
//        if (direction.equals("left")) {
//            boolean rectangleFount = coordsTable.get(coordString).get("left").contains(origin);
//            return rectangleFount ? 1 : 0;
//        } else {
//            int rectangleCount = 0;
//            String nextDirection = getNextClockwiseDirection(direction);
//            List<Point> points = coordsTable.get(coordString).get(direction);
//            for (Point nextCoord : points) {
//                rectangleCount += clockwiseCountRectangles(nextCoord, coordsTable, nextDirection, origin);
//            }
//            return rectangleCount;
//        }
//    }
//
//    private static String getNextClockwiseDirection(String direction) {
//        if (direction.equals("up")) {
//            return "right";
//        }
//        if (direction.equals("right")) {
//            return "down";
//        }
//        if (direction.equals("down")) {
//            return "left";
//        }
//        return "";
//    }
//
//
//    private static String coordToString(Point coord) {
//        int x = coord.x;
//        int y = coord.y;
//        return x + "-" + y;
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
