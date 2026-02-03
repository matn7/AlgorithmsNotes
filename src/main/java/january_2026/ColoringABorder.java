package january_2026;

import java.util.ArrayList;
import java.util.List;

public class ColoringABorder {

    public static void main(String[] args) {
//        int[][] grid = {{1,1,1},{1,1,1},{1,1,1}};
//        int row = 1;
//        int col = 1;
//        int color = 2;

        int[][] grid = {
                {1,2,1,2,1,2},
                {2,2,2,2,1,2},
                {1,2,2,2,1,2}};
        int row = 1;
        int col = 1;
        int color = 1;

        ColoringABorder coloringABorder = new ColoringABorder();
        int[][] result = coloringABorder.colorBorder(grid, row, col, color);
        System.out.println(result);
    }
    private int rows, cols;
    private int originalColor;
    private boolean[][] visited;
    private int[][] grid;
    private List<int[]> borderCells = new ArrayList<>();

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        originalColor = grid[row][col];
        visited = new boolean[rows][cols];

        dfs(row, col);

        // Kolorujemy tylko komórki brzegowe
        for (int[] cell : borderCells) {
            grid[cell[0]][cell[1]] = color;
        }

        return grid;
    }

    private void dfs(int r, int c) {
        visited[r][c] = true;
        boolean isBorder = false;

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        for (int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                isBorder = true;
            } else if (grid[nr][nc] != originalColor) {
                isBorder = true;
            } else if (!visited[nr][nc]) {
                dfs(nr, nc);
            }
        }

        if (isBorder) {
            borderCells.add(new int[]{r, c});
        }
    }
}
