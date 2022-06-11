package medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {

    public static void main(String[] args) {
//        int[][] array = {{1, 2, 3, 4},
//                         {12, 13, 14, 5},
//                         {11, 16, 15, 6},
//                         {10, 9, 8, 7}};

//        int[][] array = {{1}, {3}, {2}, {5}, {4}, {7}, {6}};

//        int[][] array = {{1,2,3},
//                         {8,9,4},
//                         {7,6,5}};

//        int[][] array = {{1, 3, 2, 5, 4, 7, 6}};

//        int[][] array = {{1,2,3,4},
//                         {10,11,12,5},
//                         {9,8,7,6}};
        int[][] array = {{1,2,3},
                         {12,13,4},
                         {11,14,5},
                         {10,15,6},
                         {9,8,7}};

        spiralTraverse(array);
    }

    public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        int startRow = 0;
        int startCol = 0;
        int endRow = array.length - 1;
        int endCol = array[0].length - 1;

        List<Integer> result = new ArrayList<>();

        if (endCol == 0) {
            for (int i = 0; i < array.length; i++) {
                result.add(array[i][0]);
            }
            return result;
        }

        if (endRow == 0) {
            for (int i = 0; i < array[0].length; i++) {
                result.add(array[0][i]);
            }
            return result;
        }

        while (startRow <= endRow && startCol <= endCol) {
            // if (startRow == endRow && startCol == endCol) {
            //     result.add(array[startRow][startCol]);
            //     break;
            // }
            for (int col = startCol; col <= endCol; col++) {
                // grab startRow index
                System.out.print(array[startRow][col] + " ");
                result.add(array[startRow][col]);
            }
            if (startRow == endRow) {
                break;
            }
            System.out.println();
            for (int row = startRow + 1; row < endRow; row++) {
                // grab endCol index
                System.out.print(array[row][endCol] + " ");
                result.add(array[row][endCol]);
            }
            System.out.println();
            for (int col = endCol; col >= startCol; col--) {
                System.out.print(array[endRow][col] + " ");
                result.add(array[endRow][col]);
            }
            if (startCol == endCol) {
                break;
            }
            System.out.println();
            for (int row = endRow - 1; row > startRow; row--) {
                System.out.print(array[row][startCol] + " ");
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
