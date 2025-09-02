package august_2025;

public class MaxAreaOfIslands {

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        MaxAreaOfIslands maxAreaOfIslands = new MaxAreaOfIslands();
        int result = maxAreaOfIslands.maxAreaOfIsland(grid);
        System.out.println(result);

    }

    // O(n * m) time | O(n * m) space
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, sink(grid, r, c));
                }
            }
        }

        return maxArea;
    }

    private int sink(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        int count = 1;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : directions) {
            count += sink(grid, r + dir[0], c + dir[1]);
        }
        return count;
    }

}
