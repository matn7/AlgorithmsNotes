package april_2025;

import java.util.Arrays;
import java.util.Map;

public class DistinctSubsequences {

    // O(n * m) time | O(n * m) space
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (n > m) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, 0, s, t, dp);
    }

    private int dfs(int i, int j, String s, String t, int[][] dp) {
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = dfs(i + 1, j + 1, s, t, dp) + dfs(i + 1, j, s, t, dp);
        } else {
            dp[i][j] = dfs(i + 1, j, s, t, dp);
        }
        return dp[i][j];
    }


}
