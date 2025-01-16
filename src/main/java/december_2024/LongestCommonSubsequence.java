package december_2024;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        int result = lcs.longestCommonSubsequence(text1, text2);
        System.out.println(result);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[] prev = new int[text1.length() + 1];
        for (int r = 0; r < text2.length(); r++) {
            int[] curr = new int[text1.length() + 1];
            for (int c = 1; c <= text1.length(); c++) {
                if (text1.charAt(c - 1) == text2.charAt(r)) {
                    curr[c] = prev[c - 1] + 1;
                } else {
                    int top = prev[c];
                    int left = curr[c - 1];
                    curr[c] = Math.max(top, left);
                }
            }
            prev = curr;
        }
        return prev[prev.length - 1];
    }

    public int longestCommonSubsequence2(String text1, String text2) {
        int[][] dp = new int[text2.length() + 1][text1.length() + 1];
        for (int r = 1; r < dp.length; r++) {
            for (int c = 1; c < dp[r].length; c++) {
                if (text2.charAt(r - 1) == text1.charAt(c - 1)) {
                    dp[r][c] = dp[r - 1][c - 1] + 1;
                } else {
                    int top = dp[r - 1][c];
                    int left = dp[r][c - 1];
                    dp[r][c] = Math.max(top, left);
                }
            }
        }
        return dp[text2.length()][text1.length()];
    }

}
