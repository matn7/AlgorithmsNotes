package november_2025;

import java.util.Arrays;

public class DistinctSubsequences3 {

    public static void main(String[] args) {
//        String s = "rabbbit";
//        String t = "rabbit";

        String s = "xxyxy";
        String t = "xy";

        DistinctSubsequences3 distinctSubsequences3 = new DistinctSubsequences3();
        int result = distinctSubsequences3.numDistinct(s, t);
        System.out.println(result);
    }

    public int numDistinct(String s, String t) {
        if (t.length() > s.length()) {
            return 0;
        }
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[m][n] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] += dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }


    // O(n * m) time | O(n * m) space
    public int numDistinct2(String s, String t) {
        if (t.length() > s.length()) {
            return 0;
        }
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(s, 0, t, 0, dp);
    }

    private int dfs(String s, int i, String t, int j, int[][] dp) {
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int res = dfs(s, i + 1, t, j, dp);
        if (s.charAt(i) == t.charAt(j)) {
            res += dfs(s, i + 1, t, j + 1, dp);
        }

        dp[i][j] = res;
        return res;
    }

}
