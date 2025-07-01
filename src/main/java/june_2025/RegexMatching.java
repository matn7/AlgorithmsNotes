package june_2025;

public class RegexMatching {

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";

        RegexMatching regexMatching = new RegexMatching();
        boolean result = regexMatching.isMatch(s, p);
        System.out.println(result);
    }

    Boolean[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];

        return dfs(0, 0, s, p, s.length(), p.length());
    }

    private boolean dfs(int i, int j, String s, String p, int m, int n) {
        if (j == n) {
            return i == m;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        boolean match = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if (j + 1 < n && (p.charAt(j + 1) == '*')) {
            dp[i][j] = dfs(i, j + 2, s, p, m, n) || (match && dfs(i + 1, j, s, p, m, n));
        } else {
            dp[i][j] = match && dfs(i + 1, j + 1, s, p, m, n);
        }
        return dp[i][j];
    }

}
