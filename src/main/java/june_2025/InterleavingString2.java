package june_2025;

public class InterleavingString2 {

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        InterleavingString2 interleavingString2 = new InterleavingString2();
        boolean result = interleavingString2.isInterleave(s1, s2, s3);
        System.out.println(result);

    }

    // O(n * m) time | O(n * m) space
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];

        return dfs(s1, s2, 0, 0, s3, dp);
    }

    private boolean dfs(String s1, String s2, int i, int j, String s3, Boolean[][] dp) {
        if (i + j == s3.length()) {
            return true;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int k = i + j;

        boolean found = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            found = dfs(s1, s2, i + 1, j, s3, dp);
            if (found) {
                return true;
            }
        }

        if (!found && j < s2.length() && s2.charAt(j)==s3.charAt(k)) {
            found = dfs(s1, s2, i, j + 1, s3, dp);
        }
        dp[i][j] = found;
        return found;
    }

}
