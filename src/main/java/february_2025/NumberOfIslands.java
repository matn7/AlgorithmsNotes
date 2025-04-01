package february_2025;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };

        NumberOfIslands numberOfIslands = new NumberOfIslands();
        int result = numberOfIslands.numIslands(grid);
        System.out.println(result);
    }

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // O(n * m) time | O(n * m) space
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
        if (r < 0 || r == grid.length || c < 0 || c == grid[r].length || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        for (int[] dir : directions) {
            int nR = r + dir[0];
            int nC = c + dir[1];
            sink(grid, nR, nC);
        }
    }

}
