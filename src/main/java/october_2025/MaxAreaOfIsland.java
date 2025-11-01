package october_2025;

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

    // O(n * m) time | O(n * m) space
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    int currArea = sink(grid, r, c);
                    maxArea = Math.max(maxArea, currArea);
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
        int currArea = 1;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] dir : directions) {
            currArea += sink(grid, r + dir[0], c + dir[1]);
        }

        return currArea;
    }

}
