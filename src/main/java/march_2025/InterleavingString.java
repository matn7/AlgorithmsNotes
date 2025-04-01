package march_2025;

public class InterleavingString {

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        InterleavingString interleavingString = new InterleavingString();
        boolean result = interleavingString.isInterleave(s1, s2, s3);
        System.out.println(result);
    }

    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs(s1, s2, s3, 0, 0);
    }

    private boolean dfs(String s1, String s2, String s3, int i, int j) {
        int k = i + j;
        if (k == s3.length()) {
            return true;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            res = dfs(s1, s2, s3, i + 1, j);
        }
        if (!res && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            res = dfs(s1, s2, s3, i, j + 1);
        }
        dp[i][j] = res;
        return res;
    }

}
