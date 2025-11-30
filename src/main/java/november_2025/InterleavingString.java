package november_2025;

public class InterleavingString {

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        InterleavingString interleavingString = new InterleavingString();
        boolean result = interleavingString.isInterleave(s1, s2, s3);
        System.out.println(result);
    }

    // O(2^n) time | O(n) space
    // O(n * m) time | O(n * m) space
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int r = 0; r < dp.length; r++) {
            for (int c = 0; c < dp[r].length; c++) {
                dp[r][c] = -1;
            }
        }

        return dfs(s1, 0, s2, 0, s3, dp);
    }

    private boolean dfs(String s1, int i, String s2, int j, String s3, int[][] dp) {
        if (s3.length() == i + j) {
            return true;
        }

        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        int k = i + j;

        boolean result = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            result = dfs(s1, i + 1, s2, j, s3, dp);
            if (result) {
                return true;
            }
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            result = dfs(s1, i, s2, j + 1, s3, dp);
        }
        dp[i][j] = result ? 1 : 0;
        return result;
    }

}
