package september_2025;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        setMatrixZeroes.setZeroes(matrix);

        System.out.println();
    }

    // O(n * m) time | O(n + m) space
    public void setZeroes(int[][] matrix) {
        boolean[] rowZeroes = new boolean[matrix.length];
        boolean[] colZeroes = new boolean[matrix[0].length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 0) {
                    rowZeroes[r] = true;
                    colZeroes[c] = true;
                }
            }
        }

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (rowZeroes[r] || colZeroes[c]) {
                    matrix[r][c] = 0;
                }
            }
        }

    }

    public void setZeroes3(int[][] matrix) {
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

    private void dfs(int[][] matrix, int r, int c, int incR, int incC) {
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length) {
            return;
        }
        matrix[r][c] = 0;
        dfs(matrix, r + incR, c + incC, incR, incC);
    }

    public void setZeroes2(int[][] matrix) {

        Queue<int[]> zeroesCoords = new LinkedList<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 0) {
                    zeroesCoords.add(new int[] {r, c});
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!zeroesCoords.isEmpty()) {
            int[] coord = zeroesCoords.poll();
            int r = coord[0];
            int c = coord[1];

            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];
                while (isWithinBounds(matrix, newRow, newCol)) {
                    matrix[newRow][newCol] = 0;
                    newRow += dir[0];
                    newCol += dir[1];
                }
            }
        }

    }

    private boolean isWithinBounds(int[][] matrix, int r, int c) {
        return r >= 0 && r <= matrix.length - 1 && c >= 0 && c <= matrix[r].length - 1;
    }
}
