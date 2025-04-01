package january_2025;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "bb";

        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        String result = longestPalindromicSubstring.longestPalindrome(s);
        System.out.println(result);
    }

    // O(n^2) time | O(1) space
    public String longestPalindrome(String s) {

        int[] res = {0, 0};
        for (int i = 0; i < s.length(); i++) {
            int[] odd = isPalindrome(s, i, i);
            int[] even = isPalindrome(s, i, i + 1);
            int[] curLongest;
            if (even[0] == -1) {
                curLongest = odd;
            }  else {
                if (odd[1] - odd[0] > even[1] - even[0]) {
                    curLongest = odd;
                } else {
                    curLongest = even;
                }
            }
            if (curLongest[1] - curLongest[0] > res[1] - res[0]) {
                res[0] = curLongest[0];
                res[1] = curLongest[1];
            }
        }

        return s.substring(res[0], res[1] + 1);
    }

    private int[] isPalindrome(String s, int l, int r) {
        if (l < 0 || r >= s.length() || s.charAt(l) != s.charAt(r)) {
            return new int[] {-1, -1};
        }

        while (l >= 0 && r <= s.length() - 1) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            }
            l--;
            r++;
        }
        return new int[] {l + 1, r - 1};
    }

}
