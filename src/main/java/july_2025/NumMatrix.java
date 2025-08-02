package july_2025;

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

    // O(n * m) time | O(n * m) space
    int[][] sumMat;

    public NumMatrix(int[][] matrix) {
        sumMat = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            int digit = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                digit += matrix[i][j];
                int above = sumMat[i][j + 1]; // above to right
                //             col = j + 1
                // row = i          above
                // row = i + 1      curr + above
                sumMat[i + 1][j + 1] = digit + above;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;
        return sumMat[row2][col2] - sumMat[row2][col1 - 1] - sumMat[row1 - 1][col2] + sumMat[row1 - 1][col1 - 1];
    }

}
