package may_2025;

import java.util.Map;

public class InterleavingStrings {


    public static void main(String[] args) {
        //  s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        InterleavingStrings interleavingStrings = new InterleavingStrings();
        boolean result = interleavingStrings.isInterleave(s1, s2, s3);
        System.out.println(result);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        return backtrack(s1, s2, s3, 0, 0, dp);
    }

    private boolean backtrack(String s1, String s2, String s3, int i, int j, int[][] dp) {
        if (i + j == s3.length()) {
            return true;
        }
        if (dp[i][j] != 0) {
            return dp[i][j] == 1;
        }
        int k = i + j;
        boolean result = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            result = backtrack(s1, s2, s3, i + 1, j, dp);
        }
        if (!result && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            result = backtrack(s1, s2, s3, i, j + 1, dp);
        }
        dp[i][j] = result ? 1 : -1;
        return result;
    }

}
