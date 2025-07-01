package june_2025;

public class CheckValidString {

    public boolean checkValidString(String s) {
        int n = s.length();
        Boolean[][] dp = new Boolean[n + 1][n + 1];
        return dfs(s, 0, 0, dp);
    }

    private boolean dfs(String s, int i, int open, Boolean[][] dp) {
        if (open < 0) {
            return false;
        }
        if (dp[i][open] != null) {
            return dp[i][open];
        }
        if (i == s.length()) {
            return open == 0;
        }
        boolean result;
        if (s.charAt(i) == '(') {
            result = dfs(s, i + 1, open + 1, dp);
        } else if (s.charAt(i) == ')') {
            result = dfs(s, i + 1, open - 1, dp);
        } else {
            result = dfs(s, i + 1, open, dp) || dfs(s, i + 1, open + 1, dp) || dfs(s, i + 1, open - 1, dp);
        }
        dp[i][open] = result;
        return result;
    }

}
