package june_2025;

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
        numMatrix.sumRegion(0, 0, 0, 0);
    }

    int[][] subMat;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        subMat = new int[rows + 1][cols + 1];
        for (int r = 0; r < rows; r++) {
            int prefix = 0;
            for (int c = 0; c < cols; c++) {
                prefix += matrix[r][c];
                int above = subMat[r][c + 1];
                subMat[r + 1][c + 1] = prefix + above;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;
        int bottomRight = subMat[row2][col2];
        int above = subMat[row1 - 1][col2];
        int left = subMat[row2][col1 - 1];
        int topLeft = subMat[row1 - 1][col1 - 1];
        return bottomRight - above - left + topLeft;
    }

}
