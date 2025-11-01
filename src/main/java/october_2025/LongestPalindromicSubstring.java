package october_2025;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "baxyzzyxkl";

        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        String result = longestPalindromicSubstring.longestPalindrome(s);
        System.out.println(result);
    }

    // O(n^2) time | O(1) space
    public String longestPalindrome(String s) {
        int[] res = new int[2];
        for (int i = 0; i < s.length() - 1; i++) {
            int[] even = checkPali(s, i, i + 1);
            int[] odd = checkPali(s, i, i);
            int[] bigger;
            if (even[1] - even[0] > odd[1] - odd[0]) {
                bigger = even;
            } else {
                bigger = odd;
            }
            if (bigger[1] - bigger[0] > res[1] - res[0]) {
                res[0] = bigger[0];
                res[1] = bigger[1];
            }
        }
        return s.substring(res[0], res[1] + 1);
    }

    private int[] checkPali(String s, int i, int j) {
        if (s.charAt(i) != s.charAt(j)) {
            return new int[] {-1, -1};
        }
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            i--;
            j++;
        }
        return new int[] {i + 1, j - 1};
    }

}
