package october_2025;

import java.util.Arrays;

public class UniquePathsII {

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
//        int[][] obstacleGrid = {{0,1},{0,0}};

        UniquePathsII uniquePaths = new UniquePathsII();
        int result = uniquePaths.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(result);
    }

    // O(n * m) time | O(n) space
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        int[] prev = new int[obstacleGrid[0].length];

        boolean colObstacle = false;
        for (int c = 0; c < obstacleGrid[0].length; c++) {
            colObstacle = colObstacle || obstacleGrid[0][c] == 1;
            if (colObstacle) {
                prev[c] = 0;
            } else {
                prev[c] = 1;
            }
        }

        for (int r = 1; r < obstacleGrid.length; r++) {
            int[] curr = new int[obstacleGrid[r].length];
            if (obstacleGrid[r][0] == 1) {
                curr[0] = 0;
            } else {
                curr[0] = prev[0];
            }
            for (int c = 1; c < obstacleGrid[r].length; c++) {
                if (obstacleGrid[r][c] == 1) {
                    curr[c] = 0;
                } else {
                    curr[c] = curr[c - 1] + prev[c];
                }
            }
            prev = curr;
        }

        return prev[prev.length - 1];
    }

    // O(n * m) time | O(n * m) space
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        boolean rowObstacle = false;
        for (int r = 0; r < obstacleGrid.length; r++) {
            rowObstacle = rowObstacle || obstacleGrid[r][0] == 1;
            if (rowObstacle) {
                dp[r][0] = 0;
            } else {
                dp[r][0] = 1;
            }
        }
        boolean colObstacle = false;
        for (int c = 0; c < obstacleGrid[0].length; c++) {
            colObstacle = colObstacle || obstacleGrid[0][c] == 1;
            if (colObstacle) {
                dp[0][c] = 0;
            } else {
                dp[0][c] = 1;
            }
        }

        for (int r = 1; r < dp.length; r++) {
            for (int c = 1; c < dp[r].length; c++) {
                if (obstacleGrid[r][c] == 1) {
                    dp[r][c] = 0;
                } else {
                    dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }


}
