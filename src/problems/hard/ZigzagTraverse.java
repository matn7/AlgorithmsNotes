package problems.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigzagTraverse {

    public static void main(String[] args) {
        List<List<Integer>> array = new ArrayList<>();
        array.add(Arrays.asList(1, 3, 4, 10));
        array.add(Arrays.asList(2, 5, 9, 11));
        array.add(Arrays.asList(6, 8, 12, 15));
        array.add(Arrays.asList(7, 13, 14, 16));

        zigzagTraverse(array);
    }
    //                          row|col
    //  c                       1|2
    //------------------
//r //  1   3   4   10          0|0     0|1     0|2     0|3
    //  2   5   9   11          1|0     1|1     1|2     1|3
    //  6   8   12  15          2|0     2|1     2|2     2|3
    //  7   13  14  16 *        3|0     3|1     3|2     3|3
    //------------------
    //
    // goingDown = true
    //
    // result = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]

    // O(n) time | O(n) space
    // OK - repeated 04/02/2022
    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        // Write your code here.
        int height = array.size() - 1; // 3
        int width = array.get(0).size() - 1; // 3

        List<Integer> result = new ArrayList<>();
        int row = 0;
        int col = 0;
        boolean goingDown = true;

        while (!isOutOfBounds(row, col, height, width)) {
            result.add(array.get(row).get(col));
            if (goingDown) {
                if (col == 0 || row == height) { // we cannot go down further
                    goingDown = false;
                    if (row == height) {
                        col++;
                    } else {
                        row++;
                    }
                } else {
                    row++;
                    col--;
                }
            } else {
                if (row == 0 || col == width) { // we cannot go up further
                    goingDown = true;
                    if (col == width) {
                        row++;
                    } else {
                        col++;
                    }
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
