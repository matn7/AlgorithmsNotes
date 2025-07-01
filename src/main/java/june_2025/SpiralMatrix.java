package june_2025;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {4, 5, 6, 5},
                {7, 8, 9, 6}
        };

        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> result = spiralMatrix.spiralOrder(matrix);
        System.out.println(result);
    }

    // O(n*m) time | O(1) space
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int topRow = 0;
        int leftCol = 0;
        int bottomRow = matrix.length - 1;
        int rightCol = matrix[0].length - 1;

        while (topRow <= bottomRow && leftCol <= rightCol) {
            for (int c = leftCol; c <= rightCol; c++) {
                result.add(matrix[topRow][c]);
            }
            for (int r = topRow + 1; r <= bottomRow; r++) {
                result.add(matrix[r][rightCol]);
            }
            for (int c = rightCol - 1; c >= leftCol; c--) {
                if (topRow == bottomRow) {
                    break;
                }
                result.add(matrix[bottomRow][c]);
            }
            for (int r = bottomRow - 1; r > topRow; r--) {
                if (leftCol == rightCol) {
                    break;
                }
                result.add(matrix[r][leftCol]);
            }
            topRow++;
            leftCol++;
            bottomRow--;
            rightCol--;
        }

        return result;
    }

}
