package june_2025;

public class DistinctSubsequences2 {

    public static void main(String[] args) {
//        String s = "rabbbit";
//        String t = "rabbit";

        String s = "babgbag";
        String t = "bag";

        DistinctSubsequences2 distinctSubsequences2 = new DistinctSubsequences2();
        int result = distinctSubsequences2.numDistinct(s, t);
        System.out.println(result);
    }

    // O(n * m) time | O(n * m) space
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int r = 0; r < dp.length; r++) {
            for (int c = 0; c < dp[r].length; c++) {
                dp[r][c] = -1;
            }
        }
        return dfs(s, t, 0, 0, dp);
    }

    private int dfs(String s, String t, int i, int j, int[][] dp) {
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
            res += dfs(s, t, i + 1, j + 1, dp);
            res += dfs(s, t, i + 1, j, dp);
        } else {
            res += dfs(s, t, i + 1, j, dp);
        }
        dp[i][j] = res;
        return res;
    }


}
