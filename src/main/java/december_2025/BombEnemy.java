package december_2025;

public class BombEnemy {

    public static void main(String[] args) {
//        char[][] grid = {
//                {'0', 'E', '0', '0'},
//                {'E', '0', 'W', 'E'},
//                {'0', 'E', '0', '0'}
//        };

//        char[][] grid = {{'0','E','E','E','E','E','E','E','E','E','E','W'}};
        
        char[][] grid = {
                {'W','W','W','W','E'},
                {'W','E','E','E','E'},
                {'W','E','0','E','0'},
                {'W','E','E','E','E'},
                {'W','W','W','W','W'}};
        
        BombEnemy bombEnemy = new BombEnemy();
        int result = bombEnemy.maxKilledEnemies(grid);
        System.out.println(result);
    }

    public int maxKilledEnemies(char[][] grid) {

        int maxCount = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 'Y') {
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
        int[][] blastRadius = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int count = 0;
        grid[r][c] = 'Y';
        for (int[] radius : blastRadius) {
            int newR = r + radius[0];
            int newC = c + radius[1];
            while (isValidPos(grid, newR, newC) && grid[newR][newC] != 'W') {
                if (grid[newR][newC] == 'E') {
                    count++;
                }
                grid[r][c] = 'Y';
                newR = newR + radius[0];
                newC = newC + radius[1];
            }
        }
        return count;
    }

    private boolean isValidPos(char[][] grid, int r, int c) {
        return r >= 0 && r <= grid.length - 1 && c >= 0 && c <= grid[r].length - 1;
    }

}
