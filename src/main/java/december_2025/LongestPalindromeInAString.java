package december_2025;

public class LongestPalindromeInAString {

    public static void main(String[] args) {
        String s = "bb";

        LongestPalindromeInAString longestPalindromeInAString = new LongestPalindromeInAString();
        String res = longestPalindromeInAString.longestPalindrome(s);
        System.out.println(res);

    }

    // O(n^2) time | O(1) space
    public String longestPalindrome(String s) {
        int[] res = new int[2];

        for (int i = 0; i < s.length(); i++) {
            int[] odd = checkPali(s, i, i);
            int[] even = checkPali(s, i, i + 1);
            int[] bigger;
            if (odd[1] - odd[0] > even[1] - even[0]) {
                bigger = odd;
            } else {
                bigger = even;
            }
            if (bigger[1] - bigger[0] > res[1] - res[0]) {
                res[0] = bigger[0];
                res[1] = bigger[1];
            }
        }

        return s.substring(res[0], res[1] + 1);
    }

    private int[] checkPali(String s, int i, int j) {
        if (j == s.length() || s.charAt(i) != s.charAt(j)) {
            return new int[] {-1, -1};
        }
        while (i >= 0 && j <= s.length() - 1) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            i--;
            j++;
        }
        return new int[] {i + 1, j - 1};
    }

}
