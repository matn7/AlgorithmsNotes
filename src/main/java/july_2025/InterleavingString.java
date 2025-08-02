package july_2025;

public class InterleavingString {

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        InterleavingString interleavingString = new InterleavingString();
        boolean result = interleavingString.isInterleave(s1, s2, s3);
        System.out.println(result);
    }

    // O(n * m) time | O(n * m) space
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs(0, s1, 0, s2, s3, dp);
    }

    private boolean dfs(int i, String s1, int j, String s2, String s3, Boolean[][] dp) {
        if (i + j == s3.length()) {
            return true;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int k = i + j;

        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            res = dfs(i + 1, s1, j, s2, s3, dp);
            if (res) {
                return true;
            }
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            res = dfs(i, s1, j + 1, s2, s3, dp);
        }
        dp[i][j] = res;
        return res;
    }

}
