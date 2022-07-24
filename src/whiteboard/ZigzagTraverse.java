package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class ZigzagTraverse {

    // O(n) time | O(n) space
    // #2: 09/07/2022
    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();

        boolean goDown = true;
        int row = 0;
        int col = 0;
        int height = array.size() - 1;
        int width = array.get(row).size() - 1;

        while (!isOutOfBounds(row, col, height, width)) {
            result.add(array.get(row).get(col));
            if (goDown) {
                if (col == 0 || row == height) {
                    goDown = false;
                    if (row == height) {
                        col += 1;
                    } else {
                        row += 1;
                    }
                } else {
                    row += 1;
                    col -= 1;
                }
            } else {
                if (row == 0 || col == width) {
                    goDown = true;
                    if (col == width) {
                        row += 1;
                    } else {
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

    private static boolean isOutOfBounds(int row, int col, int height, int width) {
        return row < 0 || row > height || col < 0 || col > width;
    }

}
