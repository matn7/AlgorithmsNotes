package february_2025;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        int result = longestCommonSubsequence.longestCommonSubsequence(text1, text2);
        System.out.println(result);
    }

    // O(n * m) time | O(n * m) space
    public int longestCommonSubsequence(String text1, String text2) {
        int[] topRow = new int[text1.length() + 1];

        for (int r = 0; r < text2.length(); r++) {
            int[] curRow = new int[text1.length() + 1];
            for (int i = 1; i <= text1.length(); i++) {
                if (text2.charAt(r) == text1.charAt(i - 1)) {
                    curRow[i] = topRow[i - 1] + 1;
                } else {
                    curRow[i] = Math.max(curRow[i - 1], Math.max(topRow[i], topRow[i - 1]));
                }
            }
            topRow = curRow;
        }
        return topRow[text1.length()];
    }

    // O(n * m) time | O(n * m) space
    public int longestCommonSubsequence2(String text1, String text2) {
        int[][] dp = new int[text2.length() + 1][text1.length() + 1];

        for (int r = 1; r < dp.length; r++) {
            for (int c = 1; c < dp[r].length; c++) {
                if (text2.charAt(r - 1) == text1.charAt(c - 1)) {
                    dp[r][c] = dp[r - 1][c - 1] + 1;
                } else {
                    dp[r][c] = Math.max(dp[r - 1][c], Math.max(dp[r][c - 1], dp[r - 1][c - 1]));
                }
            }
        }
        return dp[text2.length()][text1.length()];
    }

}
