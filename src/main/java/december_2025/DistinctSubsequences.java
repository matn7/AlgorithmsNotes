package december_2025;

public class DistinctSubsequences {

    public static void main(String[] args) {
//        String s = "rabbbit";
//        String t = "rabbit";

        String s = "babgbag";
        String t = "bag";

        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
        int result = distinctSubsequences.numDistinct(s, t);
        System.out.println(result);
    }

    // O(n * m) time | O(n * m) space
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
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

    // O(n * m) time | O(n * m) space
    public int numDistinct2(String s, String t) {
        if (t.length() > s.length()) {
            return 0;
        }
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int r = 0; r < dp.length; r++) {
            for (int c = 0; c < dp[r].length; c++) {
                dp[r][c] = -1;
            }
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
        int count = 0;
        if (s.charAt(i) == t.charAt(j)) {
            count += dfs(s, i + 1, t, j + 1, dp);
            count += dfs(s, i + 1, t, j, dp);
        } else {
            count += dfs(s, i + 1, t, j, dp);
        }
        dp[i][j] = count;
        return count;
    }

}
