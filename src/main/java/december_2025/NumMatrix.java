package december_2025;

public class NumMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        NumMatrix numMatrix = new NumMatrix(matrix);

        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }

    int[][] sumMatrix;

    // O(n * m) time | O(n * m) space
    public NumMatrix(int[][] matrix) {
        sumMatrix = new int[matrix.length][matrix[0].length];

        int sum = 0;
        for (int c = 0; c < matrix[0].length; c++) {
            sum += matrix[0][c];
            sumMatrix[0][c] = sum;
        }

        for (int r = 1; r < matrix.length; r++) {
            sum = 0;
            for (int c = 0; c < matrix[r].length; c++) {
                sum += matrix[r][c];
                sumMatrix[r][c] = sum + sumMatrix[r - 1][c];
            }
        }
    }

    // O(1) time | O(1) space
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int A = sumMatrix[row2][col2];
        int B = row1 == 0 || col1 == 0 ? 0 : sumMatrix[row1 - 1][col1 - 1];
        int C = row1 == 0 ? 0 : sumMatrix[row1 - 1][col2];
        int D = col1 == 0 ? 0 : sumMatrix[row2][col1 - 1];
        return A - C - D + B;
    }

}
