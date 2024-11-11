package november_2024;

import java.util.Arrays;

public class MinPathSum {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        MinPathSum minPathSum = new MinPathSum();
        int result = minPathSum.minPathSum(grid);
        System.out.println(result);
    }

    public int minPathSum(int[][] grid) {
        for (int r = 1; r < grid.length; r++) {
            grid[r][0] = grid[r - 1][0] + grid[r][0];
        }
        for (int c = 1; c < grid[0].length; c++) {
            grid[0][c] = grid[0][c - 1] + grid[0][c];
        }

        for (int r = 1; r < grid.length; r++) {
            for (int c = 1; c < grid[r].length; c++) {
                int left = grid[r][c - 1];
                int top = grid[r - 1][c];
                if (left < top) {
                    grid[r][c] = grid[r][c] + left;
                } else {
                    grid[r][c] = grid[r][c] + top;
                }
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }

    public int minPathSum2(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] res = new int[rows + 1][cols + 1];
        for (int[] r : res) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        res[rows - 1][cols] = 0;

        for (int r = rows - 1; r >= 0; r--) {
            for (int c = cols - 1; c >= 0; c--) {
                res[r][c] = grid[r][c] + Math.min(res[r + 1][c], res[r][c + 1]);
            }
        }
        return res[0][0];
    }
}
