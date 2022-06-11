package veryhard;

import java.util.*;

public class SquareOfZeroesREPEAT {

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>(Arrays.asList(1, 1, 1, 0, 1, 0));
        List<Integer> row2 = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 1));
        List<Integer> row3 = new ArrayList<>(Arrays.asList(0, 1, 1, 1, 0, 1));
        List<Integer> row4 = new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0, 1));
        List<Integer> row5 = new ArrayList<>(Arrays.asList(0, 1, 1, 1, 0, 1));
        List<Integer> row6 = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 1));

        matrix.add(row1);
        matrix.add(row2);
        matrix.add(row3);
        matrix.add(row4);
        matrix.add(row5);
        matrix.add(row6);

        boolean result = squareOfZeroes(matrix);
        System.out.println(result);

    }

    //  l  r
    // [1, 1, 1, 0, 1, 0]    topRow
    // [0, 0, 0, 0, 0, 1]    bottomRow
    // [0, 1, 1, 1, 0, 1]
    // [0, 0, 0, 1, 0, 1]
    // [0, 1, 1, 1, 0, 1]
    // [0, 0, 0, 0, 0, 1]

    // OK - repeated 27/02/2022
    // O(n^3) time | O(n^2) space
    public static boolean squareOfZeroes(List<List<Integer>> matrix) {
        List<List<InfoMatrix>> infoMatrix = preComputeNumOfZeroes(matrix);
        int n = matrix.size(); // 6
        for (int topRow = 0; topRow < n; topRow++) {
            for (int leftCol = 0; leftCol < n; leftCol++) {
                int squareLength = 2;
                // 2 <= 6 - 0 && 2 <= 6 - 0
                while (squareLength <= n - leftCol && squareLength <= n - topRow) {
                    // [1, 1, 1, 0, 1, 0] topRow
                    // [0, 0, 0, 0, 0, 1] bottomRow
                    int bottomRow = topRow + squareLength - 1; // 0 + 2 - 1 = 1
                    int rightCol = leftCol + squareLength - 1; // 0 + 2 - 1 = 1
                    // rec([][], 0, 0, 1, 1)
                    if (isSquareOfZeroes(infoMatrix, topRow, leftCol, bottomRow, rightCol)) {
                        return true;
                    }
                    squareLength++;
                }
            }
        }
        return false;
    }

    //    c
    // [(0,0), (0,0), (0,0), (2,1), (0,0), (1,1)]
    // [(5,5), (1,4), (1,3), (1,2), (5,1), (0,0)]   r
    // [(4,1), (0,0), (0,0), (0,0), (4,1), (0,0)] *
    // [(3,3), (1,2), (1,1), (0,0), (3,1), (0,0)]
    // [(2,1), (0,0), (0,0), (0,0), (2,1), (0,0)]
    // [(1,5), (1,4), (1,3), (1,2), (1,1), (0,0)]
    // rec([][], 0, 0, 1, 1)
    private static Boolean isSquareOfZeroes(List<List<InfoMatrix>> infoMatrix, int r1, int c1, int r2, int c2) {
        int squareLength = c2 - c1 + 1;
        boolean hasTopBorder = infoMatrix.get(r1).get(c1).numZeroesRight >= squareLength;
        boolean hasLeftBorder = infoMatrix.get(r1).get(c1).numZeroesBelow >= squareLength;
        boolean hasBottomBorder = infoMatrix.get(r2).get(c1).numZeroesRight >= squareLength;
        boolean hasRightBorder = infoMatrix.get(r1).get(c2).numZeroesBelow >= squareLength;
        return hasTopBorder && hasLeftBorder && hasBottomBorder && hasRightBorder;
    }

    private static List<List<InfoMatrix>> preComputeNumOfZeroes(List<List<Integer>> matrix) {
        List<List<InfoMatrix>> infoMatrix = new ArrayList<>();
        for (int row = 0; row < matrix.size(); row++) {
            infoMatrix.add(new ArrayList<>());
            for (int col = 0; col < matrix.get(row).size(); col++) {
                infoMatrix.get(row).add(new InfoMatrix(0, 0));
            }
        }
        //           c
        // [1, 1, 1, 0, 1, 0]
        // [0, 0, 0, 0, 0, 1]   r
        // [0, 1, 1, 1, 0, 1]
        // [0, 0, 0, 1, 0, 1]
        // [0, 1, 1, 1, 0, 1]
        // [0, 0, 0, 0, 0, 1]
        int n = matrix.size();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int numZeroes = matrix.get(row).get(col) == 0 ? 1 : 0;
                infoMatrix.get(row).get(col).numZeroesBelow = numZeroes;
                infoMatrix.get(row).get(col).numZeroesRight = numZeroes;
            }
        }

        //    c
        // [(0,0), (0,0), (0,0), (2,1), (0,0), (1,1)]
        // [(5,5), (1,4), (1,3), (1,2), (5,1), (0,0)]   r
        // [(4,1), (0,0), (0,0), (0,0), (4,1), (0,0)] *
        // [(3,3), (1,2), (1,1), (0,0), (3,1), (0,0)]
        // [(2,1), (0,0), (0,0), (0,0), (2,1), (0,0)]
        // [(1,5), (1,4), (1,3), (1,2), (1,1), (0,0)]
        int lastIdx = matrix.size() - 1; // 5
        for (int row = n - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0; col--) {
                if (matrix.get(row).get(col) == 1) {
                    continue;
                }
                if (row < lastIdx) {
                    infoMatrix.get(row).get(col).numZeroesBelow += infoMatrix.get(row + 1).get(col).numZeroesBelow;
                }
                if (col < lastIdx) {
                    infoMatrix.get(row).get(col).numZeroesRight += infoMatrix.get(row).get(col + 1).numZeroesRight;
                }
            }
        }
        return infoMatrix;
    }

    static class InfoMatrix {
        int numZeroesBelow;
        int numZeroesRight;

        public InfoMatrix(int numZeroesBelow, int numZeroesRight) {
            this.numZeroesBelow = numZeroesBelow;
            this.numZeroesRight = numZeroesRight;
        }
    }


//    // O(n^3) time | O(n^3) space
//    public static boolean squareOfZeroes(List<List<Integer>> matrix) {
//        List<List<InfoMatrix>> infoMatrix = preComputeNumOfZeroes(matrix);
//        int lastIdx = matrix.size() - 1;
//        return hasSquareOfZeroes(infoMatrix, 0, 0, lastIdx, lastIdx, new HashMap<>());
//    }
//
//    private static boolean hasSquareOfZeroes(List<List<InfoMatrix>> infoMatrix, int r1, int c1, int r2, int c2,
//                                             Map<String, Boolean> cache) {
//        if (r1 >= r2 || c1 >= c2) {
//            return false;
//        }
//        String key = r1 + "-" + c1 + "-" + r2 + "-" + c2;
//        if (cache.containsKey(key)) {
//            return cache.get(key);
//        }
//
//        cache.put(key, isSquareOfZeroes(infoMatrix, r1, c1, r2, c2) ||
//                hasSquareOfZeroes(infoMatrix, r1 + 1, c1 + 1, r2 - 1, c2 - 1, cache) ||
//                hasSquareOfZeroes(infoMatrix, r1, c1 + 1, r2 - 1, c2, cache) ||
//                hasSquareOfZeroes(infoMatrix, r1 + 1, c1, r2, c2 - 1, cache) ||
//                hasSquareOfZeroes(infoMatrix, r1 + 1, c1 + 1, r2, c2, cache) ||
//                hasSquareOfZeroes(infoMatrix, r1, c1, r2 - 1, c2 - 1, cache));
//
//        return cache.get(key);
//    }
//
//    private static Boolean isSquareOfZeroes(List<List<InfoMatrix>> infoMatrix, int r1, int c1, int r2, int c2) {
//        int squareLength = c2 - c1 + 1;
//        boolean hasTopBorder = infoMatrix.get(r1).get(c1).numZeroesRight >= squareLength;
//        boolean hasLeftBorder = infoMatrix.get(r1).get(c1).numZeroesBelow >= squareLength;
//        boolean hasBottomBorder = infoMatrix.get(r2).get(c1).numZeroesRight >= squareLength;
//        boolean hasRightBorder = infoMatrix.get(r1).get(c2).numZeroesBelow >= squareLength;
//        return hasTopBorder && hasLeftBorder && hasBottomBorder && hasRightBorder;
//    }
//
//    private static List<List<InfoMatrix>> preComputeNumOfZeroes(List<List<Integer>> matrix) {
//        List<List<InfoMatrix>> infoMatrix = new ArrayList<>();
//        for (int row = 0; row < matrix.size(); row++) {
//            infoMatrix.add(new ArrayList<>());
//            for (int col = 0; col < matrix.get(row).size(); col++) {
//                infoMatrix.get(row).add(new InfoMatrix(0, 0));
//            }
//        }
//
//        int n = matrix.size();
//        for (int row = 0; row < n; row++) {
//            for (int col = 0; col < n; col++) {
//                int numZeroes = matrix.get(row).get(col) == 0 ? 1 : 0;
//                infoMatrix.get(row).get(col).numZeroesBelow = numZeroes;
//                infoMatrix.get(row).get(col).numZeroesRight = numZeroes;
//            }
//        }
//
//        int lastIdx = matrix.size() - 1;
//        for (int row = n - 1; row >= 0; row--) {
//            for (int col = n - 1; col >= 0; col--) {
//                if (matrix.get(row).get(col) == 1) {
//                    continue;
//                }
//                if (row < lastIdx) {
//                    infoMatrix.get(row).get(col).numZeroesBelow += infoMatrix.get(row + 1).get(col).numZeroesBelow;
//                }
//                if (col < lastIdx) {
//                    infoMatrix.get(row).get(col).numZeroesRight += infoMatrix.get(row).get(col + 1).numZeroesRight;
//                }
//            }
//        }
//        return infoMatrix;
//    }
//
//    static class InfoMatrix {
//        int numZeroesBelow;
//        int numZeroesRight;
//
//        public InfoMatrix(int numZeroesBelow, int numZeroesRight) {
//            this.numZeroesBelow = numZeroesBelow;
//            this.numZeroesRight = numZeroesRight;
//        }
//    }


//
//    // O(n^4) time | O(1) space
//    public static boolean squareOfZeroes(List<List<Integer>> matrix) {
//        int n = matrix.size();
//        for (int topRow = 0; topRow < n; topRow++) {
//            for (int leftCol = 0; leftCol < n; leftCol++) {
//                int squareLength = 2;
//                while (squareLength <= n - leftCol && squareLength <= n - topRow) {
//                    int bottomRow = topRow + squareLength - 1;
//                    int rightCol = leftCol + squareLength - 1;
//                    if (isSquareOfZeroes(matrix, topRow, leftCol, bottomRow, rightCol)) {
//                        return true;
//                    }
//                    squareLength++;
//                }
//            }
//        }
//        return false;
//    }
//
//    private static Boolean isSquareOfZeroes(List<List<Integer>> matrix, int r1, int c1, int r2, int c2) {
//        for (int row = r1; row < r2 + 1; row++) {
//            if (matrix.get(row).get(c1) != 0 || matrix.get(row).get(c2) != 0) {
//                return false;
//            }
//        }
//        for (int col = c1; col < c2 + 1; col++) {
//            if (matrix.get(r1).get(col) != 0 || matrix.get(r2).get(col) != 0) {
//                return false;
//            }
//        }
//        return true;
//    }

//    // O(n^4) time | O(n^3) space
//    public static boolean squareOfZeroes(List<List<Integer>> matrix) {
//        int lastIdx = matrix.size() - 1;
//        return hasSquareOfZeroes(matrix, 0, 0, lastIdx, lastIdx, new HashMap<>());
//    }
//
//    private static boolean hasSquareOfZeroes(List<List<Integer>> matrix, int r1, int c1, int r2, int c2,
//                                             Map<String, Boolean> cache) {
//        if (r1 >= r2 || c1 >= c2) {
//            return false;
//        }
//        String key = r1 + "-" + c1 + "-" + r2 + "-" + c2;
//        if (cache.containsKey(key)) {
//            return cache.get(key);
//        }
//
//        cache.put(key, isSquareOfZeroes(matrix, r1, c1, r2, c2) ||
//                hasSquareOfZeroes(matrix, r1 + 1, c1 + 1, r2 - 1, c2 - 1, cache) ||
//                hasSquareOfZeroes(matrix, r1, c1 + 1, r2 - 1, c2, cache) ||
//                hasSquareOfZeroes(matrix, r1 + 1, c1, r2, c2 - 1, cache) ||
//                hasSquareOfZeroes(matrix, r1 + 1, c1 + 1, r2, c2, cache) ||
//                hasSquareOfZeroes(matrix, r1, c1, r2 - 1, c2 - 1, cache));
//
//        return cache.get(key);
//    }
//
//    private static Boolean isSquareOfZeroes(List<List<Integer>> matrix, int r1, int c1, int r2, int c2) {
//        for (int row = r1; row < r2 + 1; row++) {
//            if (matrix.get(row).get(c1) != 0 || matrix.get(row).get(c2) != 0) {
//                return false;
//            }
//        }
//        for (int col = c1; col < c2 + 1; col++) {
//            if (matrix.get(r1).get(col) != 0 || matrix.get(r2).get(col) != 0) {
//                return false;
//            }
//        }
//        return true;
//    }

}
