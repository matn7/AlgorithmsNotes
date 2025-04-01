package january_2025;

public class DistinctSubsequences {

    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";

        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
        int result = distinctSubsequences.numDistinct(s, t);
        System.out.println(result);
    }

    int[][] dp;

    // O(n * m) time | O(n * m) space
    public int numDistinct(String s, String t) {
        dp = new int[s.length()][t.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(0, 0, s, t);
    }

    private int dfs(int i, int j, String s, String t) {
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int res = dfs(i + 1, j, s, t);
        if (s.charAt(i) == t.charAt(j)) {
            res += dfs(i + 1, j + 1, s, t);
        }
        dp[i][j] = res;
        return res;
    }

}
