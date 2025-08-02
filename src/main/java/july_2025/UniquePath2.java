package july_2025;

public class UniquePath2 {

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};

        UniquePath2 uniquePath2 = new UniquePath2();
        int result = uniquePath2.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(result);


    }

    // O(n*m) time | O(n*m) space
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        dp[1][1] = 1;

        for (int r = 0; r < obstacleGrid.length; r++) {
            for (int c = 0; c < obstacleGrid[r].length; c++) {
                if (obstacleGrid[r][c] == 1) {
                    dp[r + 1][c + 1] = 0;
                } else {
                    dp[r + 1][c + 1] += dp[r][c + 1] + dp[r + 1][c];
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

}
