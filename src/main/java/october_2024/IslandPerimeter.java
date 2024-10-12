package october_2024;

import java.util.HashSet;
import java.util.Set;

public class IslandPerimeter {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        // [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]

        IslandPerimeter islandPerimeter = new IslandPerimeter();
        int result = islandPerimeter.islandPerimeter(grid);
        System.out.println(result);
    }

    // O(n*m) time | O(n*m) space
    public int islandPerimeter(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    // explore neighbors
                    return dfs(row, col, grid, seen);
                }
            }
        }
        return 0;
    }

    private int dfs(int row, int col, int[][] grid, boolean[][] seen) {
        if (seen[row][col]) {
            return 0;
        }
        int count = 0;
        seen[row][col] = true;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (isInBound(newRow, newCol, grid)) {
                if (grid[newRow][newCol] == 0) {
                    count++;
                } else if (grid[newRow][newCol] == 1 && !seen[newRow][newCol]) {
                    count += dfs(newRow, newCol, grid, seen);
                }
            } else {
                count++;
            }
        }
        return count;
    }

    private boolean isInBound(int row, int col, int[][] grid) {
        return row >= 0 && row <= grid.length - 1 && col >= 0 && col <= grid[row].length - 1;
    }

    public int islandPerimeter2(int[][] grid) {
        Set<String> visit = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs2(i, j, grid, visit);
                }
            }
        }
        return 0;
    }

    private int dfs2(int i, int j, int[][] grid, Set<String> visit) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == 0) {
            return 1;
        }
        String key = i + ":" + j;
        if (visit.contains(key)) {
            return 0;
        }
        visit.add(key);
        int perim = dfs2(i, j + 1, grid, visit);
        perim += dfs2(i + 1, j, grid, visit);
        perim += dfs2(i, j - 1, grid, visit);
        perim += dfs2(i - 1, j, grid, visit);
        return perim;
    }

}
