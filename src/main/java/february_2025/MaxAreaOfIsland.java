package february_2025;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        int result = maxAreaOfIsland.maxAreaOfIsland(grid);
        System.out.println(result);
    }

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    max = Math.max(max, dfs(grid, r, c));
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r == grid.length || c < 0 || c == grid[r].length || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        int count = 1;
        count += dfs(grid, r + 1, c);
        count += dfs(grid, r - 1, c);
        count += dfs(grid, r, c + 1);
        count += dfs(grid, r, c - 1);
        return count;
    }

    private int bfs(int[][] grid, int r, int c) {
        grid[r][c] = 0;
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            for (int[] dir : directions) {
                int nRow = row + dir[0];
                int nCol = col + dir[1];
                if (nRow >= 0 && nRow <= grid.length - 1 && nCol >= 0 && nCol <= grid[nRow].length - 1 && grid[nRow][nCol] == 1) {
                    queue.add(new int[] {nRow, nCol});
                    grid[nRow][nCol] = 0;
                    count++;
                }
            }
        }
        return count;
    }

}














