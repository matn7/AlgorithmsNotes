package june_2025;

public class RegexMatching2 {

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";

        RegexMatching2 regexMatching2 = new RegexMatching2();
        boolean result = regexMatching2.isMatch(s, p);
        System.out.println(result);
    }

    // O(n * m) time | O(n * m) space
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(s, p, 0, 0, dp);
    }

    private boolean dfs(String s, String p, int i, int j, Boolean[][] dp) {
        if (j == p.length()) {
            return i == s.length();
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        boolean res = false;
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            res = dfs(s, p, i, j + 2, dp) || (match && dfs(s, p, i + 1, j, dp));
        } else {
            res = match && dfs(s, p, i + 1, j + 1, dp);
        }
        dp[i][j] = res;
        return res;
    }

}
