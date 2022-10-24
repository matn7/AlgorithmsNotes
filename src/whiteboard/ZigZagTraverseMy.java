package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class ZigZagTraverseMy {

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

    // O(n) time | O(n) space
    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        // Write your code here.
        if (array.isEmpty()) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int row = 0;
        int col = 0;
        int height = array.size() - 1;
        int width = array.get(row).size() - 1;
        boolean goDown = true;

        while (!isOutOfBounds(row, col, height, width)) {
            result.add(array.get(row).get(col));
            if (goDown) {
                if (row == height) {
                    col++;
                    goDown = false;
                } else if (col == 0) {
                    row++;
                    goDown = false;
                }  else {
                    row++;
                    col--;
                }
            } else {
                if (col == width) {
                    row++;
                    goDown = true;

                } else if (row == 0) {
                    col++;
                    goDown = true;
                } else {
                    row--;
                    col++;
                }
            }
        }

        return result;
    }

    private static boolean isOutOfBounds(int row, int col, int height, int width) {
        return row < 0 || row > height || col < 0 || col > width;
    }

}
