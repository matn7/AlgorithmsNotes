package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class ZigzagTraverse2 {

    public static void main(String[] args) {
        List<List<Integer>> array = new ArrayList<>();
        int[][] arr = {
                {1, 3, 4, 10},
                {2, 5, 9, 11},
                {6, 8, 12, 15},
                {7, 13, 14, 16}
        };

        for (int[] element : arr) {
            // element = {1, 3, 4, 10}
            List<Integer> row = new ArrayList<>();
            for (int col : element) {
                row.add(col);
            }
            array.add(row);
        }

        zigzagTraverse(array);

    }

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();
        int rowSize = array.size() - 1;
        int colSize = array.get(0).size() - 1;

        int row = 0;
        int col = 0;
        boolean goingDown = true;
        int counter = 0;

        while (row <= rowSize && col <= colSize) {
            result.add(array.get(row).get(col));
            if (goingDown) {
                if (isOnBorder(row, col, rowSize, colSize)) {
                    if (row == rowSize) {
                        col += 1;
                        goingDown = false;
                    } else if (col == 0) {
                        row += 1;
                        goingDown = false;
                    } else {
                        row += 1;
                        col -= 1;
                    }
                } else {
                    row += 1;
                    col -= 1;
                }
            } else {
                if (isOnBorder(row, col, rowSize, colSize)) {
                    if (row == 0 && col == colSize) {
                        row += 1;
                        goingDown = true;
                    } else if (col == colSize) {
                        row += 1;
                        goingDown = true;
                    } else if (row == 0) {
                        col += 1;
                        goingDown = true;
                    } else {
                        row -= 1;
                        col += 1;
                    }
                } else {
                    row -= 1;
                    col += 1;
                }
            }

        }

        return result;
    }

    private static boolean isOnBorder(int row, int col, int rowSize, int colSize) {
        return row == 0 || row == rowSize || col == 0 || col == colSize;
    }

}
