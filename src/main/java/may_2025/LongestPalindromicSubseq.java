package may_2025;

public class LongestPalindromicSubseq {

    int max = 0;

    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dfs(i, i, dp, s);
            dfs(i, i + 1, dp, s);
        }
        return max;
    }

    private int dfs(int i, int j, int[][] dp, String s) {
        if (i < 0 || j == s.length()) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            int length = i == j ? 1 : 2;
            dp[i][j] = length + dfs(i - 1, j + 1, dp, s);
        } else {
            dp[i][j] = Math.max(dfs(i - 1, j, dp, s), dfs(i, j + 1, dp, s));
        }
        max = Math.max(max, dp[i][j]);
        return dp[i][j];
    }


}
