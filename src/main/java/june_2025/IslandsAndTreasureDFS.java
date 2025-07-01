package june_2025;

public class IslandsAndTreasureDFS {

    private static int R = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[][] grid = {
                {R, -1, 0, R},
                {R, R, R, -1},
                {R, -1, R, -1},
                {0, -1, R, R}
        };

        IslandsAndTreasureDFS islandsAndTreasure = new IslandsAndTreasureDFS();
        islandsAndTreasure.islandsAndTreasure(grid);
    }

    public void islandsAndTreasure(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 0) {
                    dfs(grid, r, c, 0, seen);
                }
            }
        }
    }

    private void dfs(int[][] grid, int r, int c, int val, boolean[][] seen) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length || grid[r][c] == -1 || seen[r][c]) {
            return;
        }
        grid[r][c] = Math.min(grid[r][c], val);
        seen[r][c] = true;

        dfs(grid, r + 1, c, val + 1, seen);
        dfs(grid, r - 1, c, val + 1, seen);
        dfs(grid, r, c + 1, val + 1, seen);
        dfs(grid, r, c - 1, val + 1, seen);

        seen[r][c] = false;
    }

}
