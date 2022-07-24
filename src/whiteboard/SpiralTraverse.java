package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

    public static void main(String[] args) {
//        int[][] array = {
//                {1, 2, 3, 4},
//                {12, 13, 14, 5},
//                {11, 16, 15, 6},
//                {10, 9, 8, 7}
//        };

        int[][] array = {
                {1, 2, 3, 4},
                {10, 11, 12, 5},
                {9, 8, 7, 6}
        };

        spiralTraverse(array);
    }

    // O(n) time | O(n) space
    // #2: 03/07/2022
    public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();
        int startRow = 0;
        int endRow = array.length - 1;
        int startCol = 0;
        int endCol = array[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int col = startCol; col <= endCol; col++) {
                int currVal = array[startRow][col];
                result.add(currVal);
            }

            for (int row = startRow + 1; row <= endRow; row++) {
                int currVal = array[row][endCol];
                result.add(currVal);
            }

            for (int col = endCol - 1; col >= startCol; col--) {
                if (startRow == endRow) {
                    break;
                }
                int currVal = array[endRow][col];
                result.add(currVal);
            }

            for (int row = endRow - 1; row > startRow; row--) {
                if (startCol == endCol) {
                    break;
                }
                int currVal = array[row][startCol];
                result.add(currVal);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return result;
    }

}
