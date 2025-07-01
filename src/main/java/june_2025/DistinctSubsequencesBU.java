package june_2025;

public class DistinctSubsequencesBU {

    // O(n*m) time | O(n*m) space
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int r = 0; r < dp.length; r++) {
            dp[r][n] = 1;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] += dp[i + 1][j + 1];
                    dp[i][j] += dp[i + 1][j];
                } else {
                    dp[i][j] += dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }

}
