package october_2025;

public class LongestCommonSubsequence2 {


    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        LongestCommonSubsequence2 longestCommonSubsequence = new LongestCommonSubsequence2();
        int result = longestCommonSubsequence.longestCommonSubsequence(text1, text2);
        System.out.println(result);
    }

    // O(n * m) time | O(n * m) space
    public int longestCommonSubsequence(String text1, String text2) {
        int[] prev = new int[text2.length() + 1];

        for (int r = 1; r <= text1.length(); r++) {
            int[] curr = new int[text2.length() + 1];
            for (int c = 1; c <= text2.length(); c++) {
                if (text1.charAt(r - 1) == text2.charAt(c - 1)) {
                    curr[c] = 1 + prev[c - 1];
                } else {
                    curr[c] = Math.max(curr[c - 1], prev[c]);
                }
            }
            prev = curr;
        }
        return prev[prev.length - 1];
    }


    // O(n * m) time | O(n * m) space
    public int longestCommonSubsequence2(String text1, String text2) {
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
