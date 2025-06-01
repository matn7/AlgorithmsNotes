package may_2025;

public class NumMatrix2 {

    public static void main(String[] args) {
//        int[][] matrix = {
//                {3, 0, 1, 4, 2},
//                {5, 6, 3, 2, 1},
//                {1, 2, 0, 1, 5},
//                {4, 1, 0, 1, 7},
//                {1, 0, 3, 0, 5}
//        };

        int[][] matrix = {
                {-1},
        };

        NumMatrix2 numMatrix = new NumMatrix2(matrix);
//        int result = numMatrix.sumRegion(2, 1, 4, 3);
        int result = numMatrix.sumRegion(0, 0, 0, 0);
        System.out.println(result);
    }

    int[][] sumMatrix;

    public NumMatrix2(int[][] matrix) {
        this.sumMatrix = new int[matrix.length][matrix[0].length];
        int[] above = new int[matrix.length];
        for (int r = 0; r < matrix.length; r++) {
            int sum = 0;
            for (int c = 0; c < matrix[r].length; c++) {
                sum += matrix[r][c];
                sumMatrix[r][c] = sum;
//                + above[c];
            }
            above = sumMatrix[r];
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for (int r = row1; r <= row2; r++) {
            if (col1 == 0) {
                result += this.sumMatrix[r][col2];
            } else {
                result += this.sumMatrix[r][col2] - this.sumMatrix[r][col1 - 1];
            }
        }
        return result;
    }

}
