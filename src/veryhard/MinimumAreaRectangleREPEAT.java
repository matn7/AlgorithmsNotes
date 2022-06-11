package veryhard;

import java.util.*;

public class MinimumAreaRectangleREPEAT {


    public static void main(String[] args) {
        int[][] points = {{1, 5}, {5, 1}, {4, 2}, {2, 4}, {2, 2}, {1, 2}, {4, 5}, {2, 5}, {-1, -2}};
        MinimumAreaRectangleREPEAT minimumAreaRectangle = new MinimumAreaRectangleREPEAT();
        minimumAreaRectangle.minimumAreaRectangle(points);
    }
    //         |  (1,5)(2,5)     (4,5)
    //         +    *    *         *
    //         |       (2,4)+(p2x,p2y)
    //         +         *
    //         |
    //         +
    //         |  (1,2)(2,2)     (4,2)+(p1x,p1y)
    //         +    *    *         *
    //         |                      (5,1)
    //         +                        *
    //         |
    //  --+----+----+----+----+----+----+---->
    //         |
    //         +
    //         |
    //    *    +
    // (-1,-2) |

    // OK - repeated 24/02/2022
    // O(n^2) time | O(n) space
    public int minimumAreaRectangle(int[][] points) {
        Set<String> pointSet = createPointSet(points);
        // pointSet = ["1:5","5:1","4:2","2:4","2:2","1:2","4:5","2:5","-1:-2"]
        int minimumAreaFound = 99999;

        //                                    c
        // [[1, 5], [5, 1], [4, 2], [2, 4], [2, 2], [1, 2], [4, 5], [2, 5], [-1, -2]]
        //                    p
        for (int currentIdx = 0; currentIdx < points.length; currentIdx++) {
            int[] p2 = points[currentIdx]; // [4,2]
            int p2x = p2[0]; // 2
            int p2y = p2[1]; // 4
            for (int previousIdx = 0; previousIdx < currentIdx; previousIdx++) {
                int[] p1 = points[previousIdx]; // [1,5]
                int p1x = p1[0]; // 4
                int p1y = p1[1]; // 2
                boolean pointsShareValue = p1x == p2x || p1y == p2y; // 1 == 5 || 5 == 1

                if (pointsShareValue) {
                    continue;
                }

                // opposite diagonal
                boolean point1OnOppositeDiagonalExists = pointSet.contains(convertPointToString(p1x, p2y)); // "4:4"
                boolean point2OnOppositeDiagonalExists = pointSet.contains(convertPointToString(p2x, p1y)); // "2:2"
                boolean oppositeDiagonalExists = point1OnOppositeDiagonalExists && point2OnOppositeDiagonalExists;

                if (oppositeDiagonalExists) {
                    int currentArea = Math.abs(p2x - p1x) * Math.abs(p2y - p1y); // (4-1)*(2-5)=9
                    minimumAreaFound = Math.min(minimumAreaFound, currentArea); // min(999,9) = 0
                }
            }
        }

        return minimumAreaFound != 99999 ? minimumAreaFound : 0;
    }

    private Set<String> createPointSet(int[][] points) {
        Set<String> pointSet = new HashSet<>();
        // [[1, 5], [5, 1], [4, 2], [2, 4], [2, 2], [1, 2], [4, 5], [2, 5], [-1, -2]]
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            String pointString = convertPointToString(x, y);
            pointSet.add(pointString);
        }
        return pointSet; // ["1:5","5:1","4:2","2:4","2:2","1:2","4:5","2:5","-1:-2"]
    }

    private String convertPointToString(int x, int y) {
        return x + ":" + y;
    }

//    // O(n^2) time | O(n) space
//    public int minimumAreaRectangle(int[][] points) {
//        // Write your code here.
//        Map<Integer, List<Integer>> columns = initializeColumns(points); // n
//        int minimumAreaFound = 99999;
//        Map<String, Integer> edgesParallelToYAxis = new HashMap<>();
//
//        List<Integer> sortedColumns = new ArrayList<>();
//        for (Map.Entry<Integer, List<Integer>> element : columns.entrySet()) {
//            sortedColumns.add(element.getKey());
//        }
//        Collections.sort(sortedColumns); // nlog(n)
//
//        for (Integer x : sortedColumns) { // n
//            List<Integer> yValuesInCurrentColumn = columns.get(x);
//            Collections.sort(yValuesInCurrentColumn); // nlog(n)
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
//
//                    edgesParallelToYAxis.put(pointString, x);
//                }
//            }
//        }
//
//        return minimumAreaFound != 99999 ? minimumAreaFound : 0;
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
//
//            columns.get(x).add(y);
//        }
//        return columns;
//    }


}
