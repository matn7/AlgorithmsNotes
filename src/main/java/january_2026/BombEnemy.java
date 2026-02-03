package january_2026;

public class BombEnemy {

    public static void main(String[] args) {
        char[][] grid = {
                {'0', 'E', '0', '0'},
                {'E', '0', 'W', 'E'},
                {'0', 'E', '0', '0'},
        };

        BombEnemy bombEnemy = new BombEnemy();
        int result = bombEnemy.maxKilledEnemies(grid);
        System.out.println(result);
    }

    public int maxKilledEnemies(char[][] grid) {
        int maxCount = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 'X') {
                    continue;
                }
                if (grid[r][c] == '0') {
                    maxCount = Math.max(maxCount, checkBlast(grid, r, c));
                }
            }
        }

        return maxCount;
    }

    private int checkBlast(char[][] grid, int r, int c) {
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int count = 0;
        grid[r][c] = 'X';
        for (int[] dir : directions) {
            int newRow = r + dir[0];
            int newCol = c + dir[1];

            while (isValidPos(grid, newRow, newCol) && grid[newRow][newCol] != 'W') {
                if (grid[newRow][newCol] == 'E') {
                    count++;
                }
                newRow = newRow + dir[0];
                newCol = newCol + dir[1];
            }
        }
        return count;
    }

    private boolean isValidPos(char[][] grid, int r, int c) {
        return r >= 0 && r <= grid.length - 1 && c >= 0 && c <= grid[r].length - 1;
    }


}
