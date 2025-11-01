package october_2025;

import java.util.*;

public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        setMatrixZeroes.setZeroes(matrix);

        System.out.println();

    }

    // O(n * m) time | O(1) space
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean rowZero = false;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    matrix[0][c] = 0;
                    if (r > 0) {
                        matrix[r][0] = 0;
                    } else {
                        rowZero = true;
                    }
                }
            }
        }

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[0][c] == 0 || matrix[r][0] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int r = 0; r < rows; r++) {
                matrix[r][0] = 0;
            }
        }

        if (rowZero) {
            for (int c = 0; c < cols; c++) {
                matrix[0][c] = 0;
            }
        }
    }

//    // O(n * m) time | O(n + m) space
//    public void setZeroes2(int[][] matrix) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//
//        boolean[] rows = new boolean[m];
//        boolean[] cols = new boolean[n];
//
//        for (int r = 0; r < m; r++) {
//            for (int c = 0; c < n; c++) {
//                if (matrix[r][c] == 0) {
//                    rows[r] = true;
//                    cols[c] = true;
//                }
//            }
//        }
//
//        for (int r = 0; r < m; r++) {
//            for (int c = 0; c < n; c++) {
//                if (rows[r] || cols[c]) {
//                    matrix[r][c] = 0;
//                }
//            }
//        }
//    }

}
