package december_2025;

public class NumberOfIslands {

    // O(n * m) time | O(n * m) space
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '1') {
                    sink(grid, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    private void sink(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length) {
            return;
        }
        grid[r][c] = '0';
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for (int[] dir : directions) {
            sink(grid, r + dir[0], c + dir[1]);
        }
    }

}
