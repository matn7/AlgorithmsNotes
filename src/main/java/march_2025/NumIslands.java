package march_2025;

public class NumIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'0', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        System.out.println(result);
    }

    // O(n*m) time | O(n*m) space
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    sink(grid, r, c);
                }
            }
        }

        return count;
    }

    private void sink(char[][] grid, int r, int c) {
        if (r < 0 || r > grid.length - 1 || c < 0 || c > grid[r].length - 1 || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        sink(grid, r + 1, c);
        sink(grid, r - 1, c);
        sink(grid, r, c + 1);
        sink(grid, r, c - 1);
    }

}
