package june_2025;

public class LongestCommonSubsequenceDfs {

    int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length() + 1][text2.length() + 1];

        for (int r = 0; r < dp.length; r++) {
            for (int c = 0; c < dp[r].length; c++) {
                dp[r][c] = -1;
            }
        }

        return dfs(text1, text2, 0, 0);
    }

    private int dfs(String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + dfs(text1, text2, i + 1, j + 1);
        } else {
            dp[i][j] = Math.max(dfs(text1, text2, i + 1, j), dfs(text1, text2, i, j + 1));
        }
        return dp[i][j];
    }

}
