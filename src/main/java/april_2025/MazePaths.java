package april_2025;

public class MazePaths {

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        MazePaths mazePaths = new MazePaths();
        int result = mazePaths.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(result);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][cols - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int r = 0; r < dp.length; r++) {
            if (obstacleGrid[r][0] == 1) {
                break;
            }
            dp[r][0] = 1;
        }
        for (int c = 0; c < dp[0].length; c++) {
            if (obstacleGrid[0][c] == 1) {
                break;
            }
            dp[0][c] = 1;
        }

        for (int r = 1; r < obstacleGrid.length; r++) {
            for (int c = 1; c < obstacleGrid[r].length; c++) {
                if (obstacleGrid[r][c] == 1) {
                    continue;
                }
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }

        return dp[rows - 1][cols - 1];
    }

}
