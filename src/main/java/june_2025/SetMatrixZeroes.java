package june_2025;

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
        List<int[]> coords = new ArrayList<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 0) {
                    coords.add(new int[] {r, c});
                }
            }
        }

        for (int[] coord : coords) {
            dfs(matrix, coord[0], coord[1], 0, 1);
            dfs(matrix, coord[0], coord[1], 0, -1);
            dfs(matrix, coord[0], coord[1], 1, 0);
            dfs(matrix, coord[0], coord[1], -1, 0);
        }

    }

    private void dfs(int[][] matrix, int r, int c, int incRow, int incCol) {
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length) {
            return;
        }
        matrix[r][c] = 0;
        dfs(matrix, r + incRow, c + incCol, incRow, incCol);
    }

}
