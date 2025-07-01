package june_2025;

public class UniquePathsDfs {

    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        UniquePathsDfs uniquePaths = new UniquePathsDfs();
        int result = uniquePaths.uniquePaths(m, n);
        System.out.println(result);
    }

    int[][] dp;

    // O(n*m) time | O(n*m) space
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                dp[r][c] = -1;
            }
        }
        return dfs(0, 0, m, n);
    }

    private int dfs(int i, int j, int m, int n) {
        if (i == (m - 1) && j == (n - 1)) {
            return 1;
        }
        if (i >= m || j >= n) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = dfs(i + 1, j, m, n) + dfs(i, j + 1, m, n);
        return dp[i][j];
    }

}
