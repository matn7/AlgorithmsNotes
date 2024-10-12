package october_2024;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZero {

    public static void main(String[] args) {
//        int[][] matrix = {{1, 1, 1},
//                          {1, 0, 1},
//                          {1, 1, 1}};

        // [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
        int[][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };

        SetMatrixZero setMatrixZero = new SetMatrixZero();
        setMatrixZero.setZeroes(matrix);

        System.out.println();
    }

    public void setZeroes2(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean rowZero = false;

        // determine which rows/cols need to be zero
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

    // O(n*m) time | O(n*m) space
    public void setZeroes(int[][] matrix) {

        List<int[]> zeroCoords = findCoords(matrix);

        for (int[] coord : zeroCoords) {
            resetMatrix(coord, matrix);
        }
    }

    private void resetMatrix(int[] coord, int[][] matrix) {
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int[] direction : directions) {
            int newRow = direction[0] + coord[0];
            int newCol = direction[1] + coord[1];
            while (isValidPos(newRow, newCol, matrix)) {
                matrix[newRow][newCol] = 0;
                newRow += direction[0];
                newCol += direction[1];
            }
        }
    }

    private boolean isValidPos(int row, int col, int[][] matrix) {
        return row >= 0 && row <= matrix.length - 1 && col >= 0 && col <= matrix[row].length - 1;
    }

    private List<int[]> findCoords(int[][] matrix) {
        List<int[]> coords = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    coords.add(new int[] {row, col});
                }
            }
        }
        return coords;
    }

}
