package december_2024;

public class MaxAreaOfIsland {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {0, 1, 1, 0, 1},
                {0, 1, 0, 0, 1}
        };

        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        int result = maxAreaOfIsland.maxAreaOfIsland(grid);
        System.out.println(result);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    max = Math.max(max, dfs(r, c, grid));
                }
            }
        }
        return max;
    }

    private int dfs(int r, int c, int[][] grid) {
        int count = 1;
        grid[r][c] = 2;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] direction : directions) {
            int newR = r + direction[0];
            int newC = c + direction[1];
            if (isValidPos(newR, newC, grid) && grid[newR][newC] == 1) {
                count += dfs(newR, newC, grid);
            }
        }

        return count;
    }

    private boolean isValidPos(int r, int c, int[][] grid) {
        return r >= 0 && r <= grid.length - 1 && c >= 0 && c <= grid[r].length - 1;
    }

}
