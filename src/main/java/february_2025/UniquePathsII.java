package february_2025;

public class UniquePathsII {

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        UniquePathsII uniquePathsII = new UniquePathsII();
        int result = uniquePathsII.uniquePathsWithObstacles(obstacleGrid);
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
                    dp[r][c] += dp[r + 1][c];
                    dp[r][c] += dp[r][c + 1];
                }
            }
        }

        return dp[0][0];
    }

    public int uniquePathsWithObstacles2(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int[] dp = new int[N + 1];
        dp[N - 1] = 1;

        for (int r = M - 1; r >= 0; r--) {
            for (int c = N - 1; c >= 0; c--) {
                if (grid[r][c] == 1) {
                    dp[c] = 0;
                } else {
                    dp[c] += dp[c + 1];
                }
            }
        }

        return dp[0];
    }

}
