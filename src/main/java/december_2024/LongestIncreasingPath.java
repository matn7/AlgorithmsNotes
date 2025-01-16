package december_2024;

import java.util.Arrays;

public class LongestIncreasingPath {

    public static void main(String[] args) {
        int[][] matrix = {
                {5, 5, 3},
                {2, 3, 6},
                {1, 1, 1}
        };

        LongestIncreasingPath longestIncreasingPath = new LongestIncreasingPath();
        int result = longestIncreasingPath.longestIncreasingPath(matrix);
        System.out.println(result);
    }

    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                dp[i][j] = 1;
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int max = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                for (int[] direction : directions) {
                    int newRow = r + direction[0];
                    int newCol = c + direction[1];
                    if (isValidPos(newRow, newCol, matrix)) {
                        if (matrix[newRow][newCol] > matrix[r][c]) {
                            dp[newRow][newCol] = Math.max(dp[newRow][newCol], dp[r][c] + 1);
                        }
                        max = Math.max(max, dp[newRow][newCol]);
                    }
                }
            }
        }
        return max + 1;
    }

    private boolean isValidPos(int r, int c, int[][] matrix) {
        return r >= 0 && r <= matrix.length - 1 && c >= 0 && c <= matrix[r].length - 1;
    }

}
