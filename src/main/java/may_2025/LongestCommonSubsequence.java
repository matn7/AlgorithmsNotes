package may_2025;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        int result = lcs.longestCommonSubsequence(text1, text2);
        System.out.println(result);
    }

    // O(n*m) time | O9n*m) space
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

}
