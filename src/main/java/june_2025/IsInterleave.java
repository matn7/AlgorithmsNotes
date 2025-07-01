package june_2025;

public class IsInterleave {

    public static void main(String[] args) {
        // s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        IsInterleave isInterleave = new IsInterleave();
        boolean result = isInterleave.isInterleave(s1, s2, s3);
        System.out.println(result);
    }

    // O(n*m) time | o(n*m) space
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs(s1, s2, s3, 0, 0, dp);
    }

    private boolean dfs(String s1, String s2, String s3, int i, int j, Boolean[][] dp) {
        if (i + j == s3.length()) {
            return true;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int k = i + j;

        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            res = dfs(s1, s2, s3, i + 1, j, dp);
        }
        if (!res && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            res = dfs(s1, s2, s3, i, j + 1, dp);
        }
        dp[i][j] = res;
        return res;
    }

}
