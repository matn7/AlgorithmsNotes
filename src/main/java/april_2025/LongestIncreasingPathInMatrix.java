package april_2025;

public class LongestIncreasingPathInMatrix {

    // O(n*m) time | O(n*m) space
    public int longestIncreasingPath(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int[][] dp = new int[ROWS][COLS];

        int max = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                max = Math.max(max, dfs(r, c, -1, matrix, dp));
            }
        }

        return max;
    }

    private int dfs(int r, int c, int prevVal, int[][] matrix, int[][] dp) {
        if (r < 0 || r == matrix.length || c < 0 || c == matrix[r].length || matrix[r][c] <= prevVal) {
            return 0;
        }
        if (dp[r][c] != 0) {
            return dp[r][c];
        }
        int res = 1;
        res = Math.max(res, 1 + dfs(r + 1, c, matrix[r][c], matrix, dp));
        res = Math.max(res, 1 + dfs(r - 1, c, matrix[r][c], matrix, dp));
        res = Math.max(res, 1 + dfs(r, c + 1, matrix[r][c], matrix, dp));
        res = Math.max(res, 1 + dfs(r, c - 1, matrix[r][c], matrix, dp));
        dp[r][c] = res;
        return res;
    }

}
