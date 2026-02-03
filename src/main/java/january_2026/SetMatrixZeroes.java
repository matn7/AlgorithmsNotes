package january_2026;

public class SetMatrixZeroes {

    public static void main(String[] args) {
//        int[][] matrix = {
//                {0, 1, 2, 0},
//                {3, 4, 5, 2},
//                {1, 3, 1, 5}
//        };

        int[][] matrix = {
                { 1,  2,  3,  4,  5},
                { 6,  0,  8,  9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19,  0}
        };

        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        setMatrixZeroes.setZeroes(matrix);
        System.out.println();
    }

    // O(n * m) time | O(1) space
    public void setZeroes(int[][] matrix) {
        boolean zeroRow = false;
        boolean zeroCol = false;

        for (int r = 0; r < matrix.length; r++) {
            if (matrix[r][0] == 0) {
                zeroRow = true;
                break;
            }
        }
        for (int c = 0; c < matrix[0].length; c++) {
            if (matrix[0][c] == 0) {
                zeroCol = true;
                break;
            }
        }

        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[r].length; c++) {
                if (matrix[r][c] == 0) {
                    matrix[0][c] = 0;
                    matrix[r][0] = 0;
                }
            }
        }
        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[r].length; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }
        if (zeroRow) {
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][0] = 0;
            }
        }
        if (zeroCol) {
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[0][c] = 0;
            }
        }
    }

    // O(n * m) time | O(n + m) space
    public void setZeroes2(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 0) {
                    rows[r] = true;
                    cols[c] = true;
                }
            }
        }

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (rows[r] || cols[c]) {
                    matrix[r][c] = 0;
                }
            }
        }
    }

}
