package june_2025;

public class DistinctSubsequences3 {

    public static void main(String[] args) {
//        String s = "rabbbit";
//        String t = "rabbit";

        String s = "babgbag";
        String t = "bag";

        DistinctSubsequences3 subsequences3 = new DistinctSubsequences3();
        int result = subsequences3.numDistinct(s, t);
        System.out.println(result);

    }

    // O(n * m) time | O(n * m) space
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }
        Integer[][] dp = new Integer[s.length() + 1][t.length() + 1];

        return dfs(s, t, 0, 0, dp);
    }

    private int dfs(String s, String t, int i, int j, Integer[][] dp) {
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int result = 0;
        if (s.charAt(i) == t.charAt(j)) {
            result += dfs(s, t, i + 1, j + 1, dp);
            result += dfs(s, t, i + 1, j, dp);
        } else {
            result += dfs(s, t, i + 1, j, dp);
        }
        dp[i][j] = result;
        return result;
    }

}
