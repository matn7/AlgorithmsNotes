package june_2025;

public class LongestCommonSub2 {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        LongestCommonSub2 longestCommonSub2 = new LongestCommonSub2();
        int result = longestCommonSub2.longestCommonSubsequence(text1, text2);
        System.out.println(result);
    }

    // O(n * m) time | O(n * m) space
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int r = 1; r < dp.length; r++) {
            for (int c = 1; c < dp[r].length; c++) {
                if (text1.charAt(r - 1) == text2.charAt(c - 1)) {
                    dp[r][c] = 1 + dp[r - 1][c - 1];
                } else {
                    dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

}
