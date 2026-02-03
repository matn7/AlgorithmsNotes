package january_2026;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {

    public static void main(String[] args) {
        // int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        SpiralTraversal spiralTraversal = new SpiralTraversal();
        List<Integer> result = spiralTraversal.spiralOrder(matrix);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int topRow = 0;
        int bottomRow = matrix.length - 1;
        int leftCol = 0;
        int rightCol = matrix[0].length - 1;

        while (topRow <= bottomRow && leftCol <= rightCol) {

            for (int i = leftCol; i <= rightCol; i++) {
                result.add(matrix[topRow][i]);
            }

            for (int i = topRow + 1; i <= bottomRow; i++) {
                result.add(matrix[i][rightCol]);
            }

            for (int i = rightCol - 1; i >= leftCol; i--) {
                if (topRow == bottomRow) {
                    break;
                }
                result.add(matrix[bottomRow][i]);
            }

            for (int i = bottomRow - 1; i > topRow; i--) {
                if (leftCol == rightCol) {
                    break;
                }
                result.add(matrix[i][leftCol]);
            }

            topRow++;
            bottomRow--;
            leftCol++;
            rightCol--;
        }

        return result;
    }


}
