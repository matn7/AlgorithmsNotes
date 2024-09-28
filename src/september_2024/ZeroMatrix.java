package september_2024;

public class ZeroMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 0, 9},
                {1, 4, 2, 5, 1},
                {3, 3, 8, 1, 2}
        };

        ZeroMatrix zeroMatrix = new ZeroMatrix();
        boolean result = zeroMatrix.zeroMatrix(matrix);
        System.out.println();
    }

    public boolean zeroMatrix(int[][] matrix) {

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    for (int[] direction : directions) {
                        int newRow = row + direction[0];
                        int newCol = col + direction[1];
                        while (isValidPos(newRow, newCol, matrix)) {
                            matrix[newRow][newCol] = 0;
                            newRow = newRow + direction[0];
                            newCol = newCol + direction[1];
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValidPos(int row, int col, int[][] matrix) {
        return row >= 0 && row <= matrix.length - 1 && col >= 0 && col <= matrix[row].length - 1;
    }

    // Set Zeros
    void setZeros(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        // Store the row and column index with value 0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        // Nullify rows
        for (int i = 0; i < row.length; i++) {
            if (row[i]) {
                nullifyRow(matrix, i);
            }
        }

        // Nullify columns
        for (int j = 0; j < column.length; j++) {
            if (column[j]) {
                nullifyColumn(matrix, j);
            }
        }
    }

    void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    void nullifyColumn(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

}
