package january_2025;

public class RegularExpressionMatching {

    // O(n * m) time | O(n * m) space
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        dp = new Boolean[m + 1][n + 1];
        return dfs(0, 0, s, p, m, n);
    }

    private boolean dfs(int i, int j, String s, String p, int m, int n) {
        if (j == n) {
            return i == m;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        boolean match = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (j + 1 < n && p.charAt(j + 1) == '*') {
            dp[i][j] = dfs(i, j + 2, s, p, m, n) || // not use * move j 2 pos
                        (match && dfs(i + 1, j, s, p, m, n)); // use * leave j
        } else {
            dp[i][j] = match && dfs(i + 1, j + 1, s, p, m, n); // i and j match
        }
        return dp[i][j];
    }

}
