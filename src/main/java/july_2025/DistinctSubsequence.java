package july_2025;

public class DistinctSubsequence {

    public static void main(String[] args) {
//        String s = "rabbbit";
//        String t = "rabbit";

        String s = "babgbag";
        String t = "bag";

        DistinctSubsequence distinctSubsequence = new DistinctSubsequence();
        int result = distinctSubsequence.numDistinct(s, t);
        System.out.println(result);
    }

    // O(n * m) time | O(n * m) space
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
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
        int res = 0;
        if (s.charAt(i) == t.charAt(j)) {
            res += dfs(i + 1, j + 1, s, t, dp);
            res += dfs(i + 1, j, s, t, dp);
        } else {
            res += dfs(i + 1, j, s, t, dp);
        }
        dp[i][j] = res;
        return res;
    }

}
