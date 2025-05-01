package april_2025;

public class NumMatrix {

    int[][] sumMat;

    // O(1) time | O(n * m) space
    public NumMatrix(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        sumMat = new int[ROWS + 1][COLS + 1];

        for (int r = 0; r < ROWS; r++) {
            int prefix = 0;
            for (int c = 0; c < COLS; c++) {
                prefix += matrix[r][c];
                int above = sumMat[r][c + 1];
                sumMat[r + 1][c + 1]= prefix + above;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int r1 = row1 + 1;
        int c1 = col1 + 1;
        int r2 = row2 + 1;
        int c2 = col2 + 1;

        int bottomRight = sumMat[r2][c2];
        int above = sumMat[r1 - 1][c2];
        int left = sumMat[r2][c1 - 1];
        int topLeft = sumMat[r1 - 1][c1 - 1];

        return bottomRight - above - left + topLeft;
    }
}
