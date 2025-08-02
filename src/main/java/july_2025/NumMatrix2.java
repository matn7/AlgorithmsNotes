package july_2025;

public class NumMatrix2 {

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        NumMatrix2 numMatrix = new NumMatrix2(matrix);

        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }

    // O(n * m) time | O(n * m) space
    int[][] sumMat;
    public NumMatrix2(int[][] matrix) {
        this.sumMat = new int[matrix.length + 1][matrix[0].length + 1];

        for (int r = 0; r < matrix.length; r++) {
            int prefix = 0;
            for (int c = 0; c < matrix[r].length; c++) {
                prefix += matrix[r][c];
                int above = this.sumMat[r][c + 1];
                this.sumMat[r + 1][c + 1] = prefix + above;
            }
        }
    }

    // O(1) time | O(1) space
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;
        return sumMat[row2][col2] - sumMat[row2][col1 - 1] - sumMat[row1 - 1][col2] + sumMat[row1 - 1][col1 - 1];
    }


}
