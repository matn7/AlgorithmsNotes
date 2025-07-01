package june_2025;

public class UniquePaths2 {

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        UniquePaths2 uniquePaths2 = new UniquePaths2();
        int result = uniquePaths2.uniquePaths(m, n);
        System.out.println(result);
    }

    // O(n * m) time | O(n * m) space
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(0, 0, m, n, dp);
    }

    private int dfs(int i, int j, int m, int n, int[][] dp) {
        if (i == (m - 1) && j == (n - 1)) {
            return 1;
        }
        if (i >= m || j >= n) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = dfs(i + 1, j, m, n, dp) + dfs(i, j + 1, m, n, dp);
        return dp[i][j];
    }

    // O(n * m) time | O(n * m) space
    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];

        for (int r = 0; r < m; r++) {
            dp[r][0] = 1;
        }
        for (int c = 0; c < n; c++) {
            dp[0][c] = 1;
        }

        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}
