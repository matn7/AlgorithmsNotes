package january_2026;

public class MaximalSquare {

    // O(n * m) time | O(m) space
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int[] prevRow = new int[n];
        int maxLen = 0;

        for (int i = 0; i < m; i++) {
            int[] currRow = new int[n];

            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    currRow[j] = matrix[i][j] - '0';
                } else {
                    if (matrix[i][j] == '1') {
                        currRow[j] = 1 + Math.min(currRow[j - 1], Math.min(prevRow[j - 1], prevRow[j]));
                    }
                }
                maxLen = Math.max(maxLen, currRow[j]);
            }
            prevRow = currRow;
        }
        return maxLen * maxLen;
    }

    // O(n * m) time | O(n * m) space
    public int maximalSquare2(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int maxLen = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                maxLen = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                maxLen = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return maxLen * maxLen;
    }

}
