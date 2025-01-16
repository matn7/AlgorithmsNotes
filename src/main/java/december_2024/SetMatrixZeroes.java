package december_2024;

import november_2024.SearchMatrix;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        setMatrixZeroes.setZeroes(matrix);
        System.out.println();
    }

    public void setZeroes(int[][] matrix) {
        List<int[]> cords = new ArrayList<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 0) {
                    cords.add(new int[] {r, c});
                }
            }
        }

        for (int[] cord : cords) {
            int row = cord[0];
            int col = cord[1];
            for (int i = row; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
            for (int i = row; i >= 0; i--) {
                matrix[i][col] = 0;
            }
            for (int i = col; i < matrix[row].length; i++) {
                matrix[row][i] = 0;
            }
            for (int i = col; i >= 0; i--) {
                matrix[row][i] = 0;
            }
        }
    }


}
