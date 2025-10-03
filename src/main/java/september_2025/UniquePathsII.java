package september_2025;

import java.util.Arrays;

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

    // O(n * m) time | O(n * m) space
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        dp = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                dp[r][c] = -1;
            }
        }

        return dfs(0, 0, obstacleGrid);
    }

    private int dfs(int r, int c, int[][] grid) {
        if (r == grid.length || c == grid[0].length || grid[r][c] == 1) {
            return 0;
        }
        if (r == grid.length - 1 && c == grid[r].length - 1) {
            return 1;
        }
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        dp[r][c] = dfs(r + 1, c, grid) + dfs(r, c + 1, grid);
        return dp[r][c];
    }

    // O(n * m) time | O(n) space
    public int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n + 1];

        dp[n - 1] = 1;

        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (obstacleGrid[r][c] == 1) {
                    dp[c] = 0;
                } else {
                    dp[c] += dp[c + 1];
                }
            }
        }
        return dp[0];
    }

    // O(n * m) time | O(n * m) space
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int r = 0; r < m; r++) {
            if (obstacleGrid[r][0] == 1) {
                dp[r][0] = 0;
                break;
            } else {
                dp[r][0] = 1;
            }
        }

        for (int c = 0; c < n; c++) {
            if (obstacleGrid[0][c] == 1) {
                dp[0][c] = 0;
                break;
            } else {
                dp[0][c] = 1;
            }
        }

        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (obstacleGrid[r][c] == 0) {
                    dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

}
