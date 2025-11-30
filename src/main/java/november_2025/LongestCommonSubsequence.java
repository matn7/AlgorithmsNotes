package november_2025;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        int result = longestCommonSubsequence.longestCommonSubsequence(text1, text2);
        System.out.println(result);
    }

    // O(n * m) time | O(m) space
    public int longestCommonSubsequence(String text1, String text2) {
//        int[][] dp = new int[text2.length() + 1][text1.length() + 1];
        int[] dp = new int[text1.length() + 1];

        for (int r = 1; r <= text2.length(); r++) {
            int[] nextDp = new int[text1.length() + 1];
            for (int c = 1; c <= text1.length(); c++) {
                if (text1.charAt(c - 1) == text2.charAt(r - 1)) {
                    nextDp[c] = 1 + dp[c - 1];
                } else {
                    nextDp[c] = Math.max(dp[c], Math.max(nextDp[c - 1], dp[c - 1]));
                }
            }
            dp = nextDp;
        }
        return dp[text1.length()];
    }



}
