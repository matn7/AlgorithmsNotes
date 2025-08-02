package july_2025;

public class LongestPalindromeSubseq {

    public static void main(String[] args) {
        String s = "bbbab";

        LongestPalindromeSubseq palindromeSubseq = new LongestPalindromeSubseq();
        int result = palindromeSubseq.longestPalindromeSubseq(s);
        System.out.println(result);
    }

    // O(n^2) time | O(n^2) space
    public int longestPalindromeSubseq(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        return helper(s, s2);
    }

    private int helper(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

}
