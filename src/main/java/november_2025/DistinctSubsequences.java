package november_2025;

public class DistinctSubsequences {

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";

        s="caaat";
        t="cat";

        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
        int result = distinctSubsequences.numDistinct(s, t);
        System.out.println(result);
    }

    // O(n * m) time | O(n * m) space
    public int numDistinct(String s, String t) {
        if (t.length() > s.length()) {
            return 0;
        }
        int m = s.length();
        int n = t.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            int[] nextDp = new int[n + 1];
            nextDp[n] = 1;
            for (int j = n - 1; j >= 0; j--) {
                nextDp[j] = dp[j];
                if (s.charAt(i) == t.charAt(j)) {
                    nextDp[j] += dp[j + 1];
                }
            }
            dp = nextDp;
        }

        return dp[0];
    }

    // O(2^n) time | O(n) space - no memo
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
        return dfs2(s, 0, t, 0, dp);
    }

    private int dfs2(String s, int i, String t, int j, int[][] dp) {
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int res = 0;
        if (s.charAt(i) == t.charAt(j)) {
            res += dfs2(s, i + 1, t, j + 1, dp);
            res += dfs2(s, i + 1, t, j, dp);
        } else {
            res += dfs2(s, i + 1, t, j, dp);
        }
        dp[i][j] = res;
        return res;
    }


}
