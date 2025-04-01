package february_2025;

public class UniquePaths2 {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        UniquePaths2 uniquePaths2 = new UniquePaths2();
        int result = uniquePaths2.uniquePathsWithObstacles(grid);
        System.out.println(result);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][cols - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[rows + 1][cols + 1];
        dp[rows - 1][cols - 1] = 1;

        for (int r = rows - 1; r >= 0; r--) {
            for (int c = cols - 1; c >= 0; c--) {
                if (obstacleGrid[r][c] == 1) {
                    dp[r][c] = 0;
                } else {
                    dp[r][c] += dp[r][c + 1];
                    dp[r][c] += dp[r + 1][c];
                }
            }
        }
        return dp[0][0];
    }

}
