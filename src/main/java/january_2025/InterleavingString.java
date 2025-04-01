package january_2025;

public class InterleavingString {

    public static void main(String[] args) {
//        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
        InterleavingString interleavingString = new InterleavingString();
        boolean result = interleavingString.isInterleave(s1, s2, s3);
        System.out.println(result);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        Boolean[][] dp = new Boolean[s1.length()][s2.length()];
        return helper(0, 0, s1, s2, s3, dp);
    }

    private boolean helper(int i, int j, String s1, String s2, String s3, Boolean[][] dp) {
        int k = i + j;
        if (k == s3.length()) {
            return true;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            res = helper(i + 1, j, s1, s2, s3, dp);
        }

        if (!res && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            res = helper(i, j + 1, s1, s2, s3, dp);
        }
        dp[i][j] = res;
        return res;
    }

}
