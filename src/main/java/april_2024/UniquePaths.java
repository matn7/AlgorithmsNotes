package april_2024;

import java.util.Arrays;

public class UniquePaths {

    public static void main(String[] args) {

        int result = uniquePaths(4, 4);

        System.out.println(result);

    }

    // O(n*m) time | O(n*m) space
    public static int uniquePaths(int numRows, int numCols) {

        int[][] matrix = new int[numRows][numCols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row][0] = 1;
        }
        Arrays.fill(matrix[0], 1);

        for (int row = 1; row < numRows; row++) {
            for (int col = 1; col < numCols; col++) {
                matrix[row][col] = matrix[row - 1][col] + matrix[row][col - 1];
            }
        }

        // 1 1 1 1
        // 1 2 3 4
        // 1 3 6 10
        // 1 4 10 20
        return matrix[numRows - 1][numCols - 1];
    }

}
