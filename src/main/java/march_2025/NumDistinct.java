package march_2025;

public class NumDistinct {

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";

        NumDistinct numDistinct = new NumDistinct();
        int result = numDistinct.numDistinct(s, t);
        System.out.println(result);
    }

    int[][] dp;
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }
        dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        return dfs(s, t, 0, 0);
    }

    private int dfs(String s, String t, int i, int j) {
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
            dp[i][j] = dfs(s, t, i + 1, j + 1) + dfs(s, t, i + 1, j);
        } else {
            dp[i][j] = dfs(s, t, i + 1, j);
        }
        return dp[i][j];
    }

}
