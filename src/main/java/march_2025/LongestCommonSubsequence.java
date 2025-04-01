package march_2025;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        int ressult = lcs.longestCommonSubsequence(text1, text2);
        System.out.println(ressult);
    }

    // O(n * m) time | O(n * m) space
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int[][] dp = new int[text2.length() + 1][text1.length() + 1];

        for (int r = 1; r <= text2.length(); r++) {
            for (int c = 1; c <= text1.length(); c++) {
                if (text2.charAt(r - 1) == text1.charAt(c - 1)) {
                    dp[r][c] = 1 + dp[r - 1][c - 1];
                } else {
                    dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
                }
            }
        }
        return dp[text2.length()][text1.length()];
    }

}
