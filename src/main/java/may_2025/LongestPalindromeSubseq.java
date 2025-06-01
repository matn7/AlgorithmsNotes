package may_2025;

import java.util.Arrays;

public class LongestPalindromeSubseq {

    public static void main(String[] args) {
        LongestPalindromeSubseq lps = new LongestPalindromeSubseq();
        int result = lps.longestPalindromeSubseq("aaaba");
        System.out.println(result);
    }

    int[][] dp;

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new int[n + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(0, n - 1, s);
    }

    private int dfs(int i, int j, String s) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = dfs(i + 1, j - 1, s) + 2;
        } else {
            dp[i][j] = Math.max(dfs(i + 1, j, s), dfs(i, j - 1, s));
        }
        return dp[i][j];
    }




    // O(n^2) time | O(s) space
    public int longestPalindromeSubseq2(String s) {
        String t = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s.length()][t.length()];
    }

}
