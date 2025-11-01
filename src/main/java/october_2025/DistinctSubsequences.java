package october_2025;

public class DistinctSubsequences {

    public static void main(String[] args) {
//        String s = "rabbbit", t = "rabbit";
        String s = "babgbag", t = "bag";

        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
        int result = distinctSubsequences.numDistinct(s, t);
        System.out.println(result);
    }

    // O(n * m) time | O(n * m) space
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
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
