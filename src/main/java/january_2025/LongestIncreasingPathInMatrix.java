package january_2025;

import java.util.Arrays;

public class LongestIncreasingPathInMatrix {

    public static void main(String[] args) {
//        int[][] matrix = {
//                {9, 9, 4},
//                {6, 6, 8},
//                {2, 1, 1}
//        };

        int[][] matrix = {
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        };

        LongestIncreasingPathInMatrix longestIncreasingPathInMatrix = new LongestIncreasingPathInMatrix();
        int result = longestIncreasingPathInMatrix.longestIncreasingPath(matrix);
        System.out.println(result);
    }

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                dp[r][c] = -1;
            }
        }

        int res = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                res = Math.max(res, dfs(r, c, matrix, Integer.MIN_VALUE));
            }
        }
        return res;
    }

    private int dfs(int r, int c, int[][] matrix, int prevVal) {
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length || matrix[r][c] <= prevVal) {
            return 0;
        }
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        int res = 1;
        for (int[] d : directions) {
            res = Math.max(res, 1 + dfs(r + d[0], c + d[1], matrix, matrix[r][c]));
        }
        dp[r][c] = res;
        return res;
    }


}
