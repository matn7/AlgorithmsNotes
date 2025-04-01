package march_2025;

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
        List<Integer> result = spiralMatrix.spiralOrder(matrix);
        System.out.println(result);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int startRow = 0;
        int endRow = matrix.length - 1;
        
        int startCol = 0;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int i = startCol; i <= endCol; i++) {
                result.add(matrix[startRow][i]);
            }

            for (int i = startRow + 1; i <= endRow; i++) {
                result.add(matrix[i][endCol]);
            }

            for (int i = endCol - 1; i >= startCol; i--) {
                if (startRow == endRow) {
                    break;
                }
                result.add(matrix[endRow][i]);
            }

            for (int i = endRow - 1; i > startRow; i--) {
                if (startCol == endCol) {
                    break;
                }
                result.add(matrix[i][startCol]);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return result;
    }

}
