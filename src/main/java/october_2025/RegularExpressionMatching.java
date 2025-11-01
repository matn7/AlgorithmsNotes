package october_2025;

public class RegularExpressionMatching {

    // O(n * m) time | O(n * m) space
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        dp = new Boolean[m + 1][n + 1];

        return dfs(s, p, 0, 0, m, n);
    }

    private boolean dfs(String s, String p, int i, int j, int m, int n) {
        if (j == n) {
            return i == m;
        }
        boolean match = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (j + 1 < n && p.charAt(j + 1) == '*') {
            dp[i][j] = dfs(s, p, i, j + 2, m, n) || (match && dfs(s, p, i + 1, j, m, n));
        } else {
            dp[i][j] = match && dfs(s, p, i + 1, j + 1, m, n);
        }
        return dp[i][j];
    }



}
