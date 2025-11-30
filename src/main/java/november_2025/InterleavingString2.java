package november_2025;

public class InterleavingString2 {

    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";

        InterleavingString2 interleavingString2 = new InterleavingString2();
        boolean result = interleavingString2.isInterleave(s1, s2, s3);
        System.out.println(result);
    }

    // O(n * m) time | O(n * m) space
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;

        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i < m && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) {
                    dp[i][j] = true;
                }
                if (j < n && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[0][0];
    }

    // O(n * m) time | O(n * m) space
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return helper(s1, 0, s2, 0, s3, dp);
    }

    private boolean helper(String s1, int i, String s2, int j, String s3, Boolean[][] dp) {
        if (i + j == s3.length()) {
            return true;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int k = i + j;
        boolean result = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            result = helper(s1, i + 1, s2, j, s3, dp);
            if (result) {
                return true;
            }
        }
        if (j < s2.length() && !result && s2.charAt(j) == s3.charAt(k)) {
            result = helper(s1, i, s2, j + 1, s3, dp);
        }

        dp[i][j] = result;

        return result;
    }

}
