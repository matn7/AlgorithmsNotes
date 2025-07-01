package june_2025;

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
                    sink(r, c, grid);
                }
            }
        }

        return count;
    }

    private void sink(int r, int c, char[][] grid) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        sink(r + 1, c, grid);
        sink(r - 1, c, grid);
        sink(r, c + 1, grid);
        sink(r, c - 1, grid);
    }

}
