package march_2025;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String s = "cbbd";
        LongestPalindromicSubsequence longestPalindromicSubsequence = new LongestPalindromicSubsequence();
        int result = longestPalindromicSubsequence.longestPalindromeSubseq(s);
        System.out.println(result);
    }

    int[][] dp;
    // O(n^2) time | O(n^2) space
    public int longestPalindromeSubseq(String s) {
        dp = new int[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(s, 0, s.length() - 1);
    }

    private int helper(String s, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = helper(s, i + 1, j - 1) + 2;
        } else {
            dp[i][j] = Math.max(helper(s, i, j - 1), helper(s, i + 1, j));
        }
        return dp[i][j];
    }

}
