package problems.veryhard;

import java.util.*;

public class MinimumAreaRectangle {

    public static void main(String[] args) {
        int[][] points = {{1, 5}, {5, 1}, {4, 2}, {2, 4}, {1, 2}, {1, 2}, {4, 5}, {2, 5}, {-1, -2}};
        MinimumAreaRectangle minimumAreaRectangle = new MinimumAreaRectangle();
        minimumAreaRectangle.minimumAreaRectangle(points);
    }

    // O(n^2) time | O(n) space
    public int minimumAreaRectangle(int[][] points) {
        Set<String> pointSet = createPointSet(points);
        int minimumAreaFound = 99999;

        for (int currentIdx = 0; currentIdx < points.length; currentIdx++) {
            int p2x = points[currentIdx][0];
            int p2y = points[currentIdx][1];
            for (int previousIdx = 0; previousIdx < currentIdx; previousIdx++) {
                int p1x = points[previousIdx][0];
                int p1y = points[previousIdx][1];
                boolean pointsShareValue = p1x == p2x || p1y == p2y;

                if (pointsShareValue) {
                    continue;
                }

                boolean point1OnOppositeDiagonalExists = pointSet.contains(convertPointToString(p1x, p2y));
                boolean point2OnOppositeDiagonalExists = pointSet.contains(convertPointToString(p2x, p1y));
                boolean oppositeDiagonalExists = point1OnOppositeDiagonalExists && point2OnOppositeDiagonalExists;

                if (oppositeDiagonalExists) {
                    int currentArea = Math.abs(p2x - p1x) * Math.abs(p2y - p1y);
                    minimumAreaFound = Math.min(minimumAreaFound, currentArea);
                }
            }
        }
        if (minimumAreaFound != 99999) {
            return minimumAreaFound;
        }
        return 0;
    }

    private Set<String> createPointSet(int[][] points) {
        Set<String> pointSet = new HashSet<>();

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            String pointString = convertPointToString(x, y);
            pointSet.add(pointString);
        }
        return pointSet;
    }

    private String convertPointToString(int x, int y) {
        return x + ":" + y;
    }

//    // O(n^2) time | O(n) space
//    public int minimumAreaRectangle(int[][] points) {
//        // Write your code here.
//        Map<Integer, List<Integer>> columns = initializeColumns(points);
//        int minimumAreaFound = 99999;
//        Map<String, Integer> edgesParallelToYAxis = new HashMap<>();
//
//        List<Integer> sortedColumns = new ArrayList<>();
//        for (Map.Entry<Integer, List<Integer>> element : columns.entrySet()) {
//            sortedColumns.add(element.getKey());
//        }
//
//        Collections.sort(sortedColumns);
//
//        for (int x : sortedColumns) {
//            List<Integer> yValuesInCurrentColumn = columns.get(x);
//            Collections.sort(yValuesInCurrentColumn);
//
//            for (int currentIdx = 0; currentIdx < yValuesInCurrentColumn.size(); currentIdx++) {
//                Integer y2 = yValuesInCurrentColumn.get(currentIdx);
//                for (int previousIdx = 0; previousIdx < currentIdx; previousIdx++) {
//                    Integer y1 = yValuesInCurrentColumn.get(previousIdx);
//                    String pointString = y1 + ":" + y2;
//                    if (edgesParallelToYAxis.containsKey(pointString)) {
//                        int currentArea = (x - edgesParallelToYAxis.get(pointString)) * (y2 - y1);
//                        minimumAreaFound = Math.min(minimumAreaFound, currentArea);
//                    }
//                    edgesParallelToYAxis.put(pointString, x);
//                }
//
//            }
//        }
//
//        if (minimumAreaFound != 99999) {
//            return minimumAreaFound;
//        }
//        return 0;
//    }
//
//    private Map<Integer, List<Integer>> initializeColumns(int[][] points) {
//        Map<Integer, List<Integer>> columns = new HashMap<>();
//        for (int[] point : points) {
//            int x = point[0];
//            int y = point[1];
//            if (!columns.containsKey(x)) {
//                columns.put(x, new ArrayList<>());
//            }
//            columns.get(x).add(y);
//        }
//        return columns;
//    }

}
