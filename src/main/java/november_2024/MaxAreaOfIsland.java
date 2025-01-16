package november_2024;

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
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        int result = maxAreaOfIsland.maxAreaOfIsland(grid);
        System.out.println(result);
    }

    public int maxAreaOfIsland(int[][] grid) {

        int max = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    int count = explore(grid, row, col);
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }

    private int explore(int[][] grid, int row, int col) {
        grid[row][col] = 2;
        int count = 1;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (isValidPos(grid, newRow, newCol) && grid[newRow][newCol] == 1) {
                count += explore(grid, newRow, newCol);
            }
        }

        return count;
    }

    private boolean isValidPos(int[][] grid, int row, int col) {
        return row >= 0 && row <= grid.length - 1 && col >= 0 && col <= grid[row].length - 1;
    }

}

















