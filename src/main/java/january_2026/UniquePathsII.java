package january_2026;

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

    // O(n * m) time | O(n) space
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][cols - 1] == 1) {
            return 0;
        }

        int[] prev = new int[cols + 1];
        prev[cols - 1] = 1;

        for (int r = rows - 1; r >= 0; r--) {
            int[] curr = new int[cols + 1];
            for (int c = cols - 1; c >= 0; c--) {
                if (obstacleGrid[r][c] == 0) {
                    curr[c] = prev[c] + curr[c + 1];
                } else {
                    curr[c] = 0;
                }
            }
            prev = curr;
        }

        return prev[0];
    }

}
