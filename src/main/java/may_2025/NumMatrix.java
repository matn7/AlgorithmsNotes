package may_2025;

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
        int result = numMatrix.sumRegion(2, 1, 4, 3);
//        int result = numMatrix.sumRegion(0, 0, 0, 0);
        System.out.println(result);
    }

    int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        this.sumMatrix = new int[matrix.length + 1][matrix[0].length + 1];
        int[] above = new int[sumMatrix[0].length];
        for (int r = 0; r < matrix.length; r++) {
            int sum = 0;
            for (int c = 0; c < matrix[r].length; c++) {
                sum += matrix[r][c];
                sumMatrix[r + 1][c + 1] = sum + above[c + 1];
            }
            above = sumMatrix[r + 1];
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int S = this.sumMatrix[row2 + 1][col2 + 1];
        int A = this.sumMatrix[row2 + 1][col1];
        int B = this.sumMatrix[row1][col2 + 1];
        int C = this.sumMatrix[row1][col1];
        return S - A - B + C;
    }

}
