package october_2024;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> integers = spiralMatrix.spiralOrder(matrix);
        System.out.println(integers);
    }

    // O(n) time | O(n) space
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int c = startCol; c <= endCol; c++) {
                result.add(matrix[startRow][c]);
            }
            for (int r = startRow + 1; r <= endRow; r++) {
                result.add(matrix[r][endCol]);
            }
            for (int c = endCol - 1; c >= startCol; c--) {
                if (startRow == endRow) {
                    break;
                }
                result.add(matrix[endRow][c]);
            }
            for (int r = endRow - 1; r > startRow; r--) {
                if (startCol == endCol) {
                    break;
                }
                result.add(matrix[r][startCol]);
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return result;
    }

}
