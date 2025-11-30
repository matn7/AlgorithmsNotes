package november_2025;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String s = "cbbd";
        LongestPalindromicSubsequence longestPalindromicSubsequence = new LongestPalindromicSubsequence();
        int result = longestPalindromicSubsequence.longestPalindromeSubseq(s);
        System.out.println(result);
    }

    // O(n * m) time | O(n) space
    public int longestPalindromeSubseq(String s) {
        String s2 = new StringBuilder(s).reverse().toString();

        int[] above = new int[s2.length() + 1];
            // [0, 0, 0, 0, 0]

        for (int r = 1; r <= s.length(); r++) {
            int[] curr = new int[s2.length() + 1];
            //     c
            // [0, 0, 0, 0, 0]
            for (int c = 1; c <= s2.length(); c++) {
                if (s.charAt(r - 1) == s2.charAt(c - 1)) {
                    curr[c] = 1 + above[c - 1];
                } else {
                    curr[c] = Math.max(curr[c - 1], Math.max(above[c - 1], above[c]));
                }
            }
            above = curr;
        }
        return above[s2.length()];
    }

}
