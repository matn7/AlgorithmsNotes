package october_2025;

import java.util.ArrayDeque;

public class MaxAreaOfIslands2 {

    // O(n * m) time | O(n * m) space
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, sinkBfs(grid, r, c));
                }
            }
        }
        return maxArea;
    }

    private int sinkBfs(int[][] grid, int r, int c) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {r, c});
        grid[r][c] = 0;
        int count = 1;
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] current = queue.removeFirst();
            int r1 = current[0];
            int c1 = current[1];

            for (int[] dir : directions) {
                int r2 = r1 + dir[0];
                int c2 = c1 + dir[1];
                if (isValidPos(grid, r2, c2) && grid[r2][c2] == 1) {
                    queue.add(new int[] {r2, c2});
                    grid[r2][c2] = 0;
                    count++;
                }
            }

        }
        return count;
    }

    private boolean isValidPos(int[][] grid, int r, int c) {
        return r >= 0 && r <= grid.length - 1 && c >= 0 && c <= grid[r].length - 1;
    }

    private int sink(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        int count = 1;
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1, 0}};

        for (int[] dir : directions) {
            count += sink(grid, r + dir[0], c + dir[1]);
        }
        return count;
    }

}
