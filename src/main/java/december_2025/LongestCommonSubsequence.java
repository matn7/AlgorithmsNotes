package december_2025;

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
//        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        int[] prev = new int[text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            int[] curr = new int[text2.length() + 1];
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
//                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    curr[j] = 1 + prev[j - 1];
                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1]));
                    curr[j] = Math.max(prev[j], Math.max(curr[j - 1], prev[j - 1]));
                }
            }
            prev = curr;
        }
        return prev[prev.length - 1];
    }

}
