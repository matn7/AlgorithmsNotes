package medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverseREPEAT {

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };

        spiralTraverse(array);
    }

    // O(n) time | O(n) space
    // OK - repeated 16/02/2022
//    public static List<Integer> spiralTraverse(int[][] array) {
//        // Write your code here.
//        List<Integer> result = new ArrayList<>();
//        spiralFill(array, 0, array.length - 1, 0, array[0].length - 1, result);
//        return result;
//    }
//
//    // rec([], 2, 1, 2, 1) => return
//    // rec([], 1, 2, 1, 2) => result = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
//    // rec([], 0, 3, 0, 3) => result = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
//    public static void spiralFill(int[][] array, int startRow, int endRow, int startCol, int endCol, List<Integer> result) {
//        if (startRow > endRow || startCol > endCol) {
//            return;
//        }
//        //      s  e
//        //      *
//        //   1  2  3  4
//        //  12 13 14  5 * startRow
//        //  11 16 15  6   endRow
//        //  10  9  8  7
//        // result = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
//        for (int col = startCol; col <= endCol; col++) {
//            result.add(array[startRow][col]);
//        }
//        for (int row = startRow + 1; row <= endRow; row++) {
//            result.add(array[row][endCol]);
//        }
//        for (int col = endCol - 1; col >= startCol; col--) {
//            if (startRow == endRow) {
//                break;
//            }
//            result.add(array[endRow][col]);
//        }
//        for (int row = endRow - 1; row > startRow; row--) {
//            if (startCol == endCol) {
//                break;
//            }
//            result.add(array[row][startCol]);
//        }
//
//        spiralFill(array, startRow + 1, endRow - 1, startCol + 1, endCol - 1, result);
//    }

    // O(n) time | O(n) space
    public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();
        int startRow = 0;
        int endRow = array.length - 1;
        int startCol = 0;
        int endCol = array[0].length - 1;
        //      ec st
        //      *
        // -------------+
        //   1  2  3  4 |
        //  12 13 14  5 | * endRow
        //  11 16 15  6 |   startRow
        //  10  9  8  7 |

        // result = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
        while (startRow <= endRow && startCol <= endCol) {
            for (int col = startCol; col <= endCol; col++) {
                result.add(array[startRow][col]);
            }
            for (int row = startRow + 1; row <= endRow; row++) {
                result.add(array[row][endCol]);
            }
            for (int col = endCol - 1; col >= startCol; col--) {
                if (startRow == endRow) {
                    break;
                }
                result.add(array[endRow][col]);
            }
            for (int row = endRow - 1; row > startRow; row--) {
                if (startCol == endCol) {
                    break;
                }
                result.add(array[row][startCol]);
            }
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return result;
    }

}
















