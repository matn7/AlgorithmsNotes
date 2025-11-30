package may_2025;

import java.util.Arrays;

public class NumDistinct {

    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";

        NumDistinct numDistinct = new NumDistinct();
        int result = numDistinct.numDistinct(s, t);
        System.out.println(result);
    }

    // O(n * m) time | O(n * m) space
    public int numDistinct(String s, String t) {
        if (t.length() > s.length()) {
            return 0;
        }

        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
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
//        int res = 0;
        dp[i][j] = 0;
        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] += dfs(s, i + 1, t, j + 1, dp);
            dp[i][j] += dfs(s, i + 1, t, j, dp);
        } else {
            dp[i][j] += dfs(s, i + 1, t, j, dp);
        }
        return dp[i][j];
    }

}

