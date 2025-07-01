package june_2025;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babadxyyzzyyxd";

        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        String result = longestPalindromicSubstring.longestPalindrome(s);
        System.out.println(result);
    }

    // O(n^2) time | O(n) space
    public String longestPalindrome(String s) {

        int[] longest = {0, 0};

        for (int i = 0; i < s.length(); i++) {
            int[] odd = checkPalindrome(s, i, i);
            int[] even = checkPalindrome(s, i, i + 1);
            int[] longer = {};
            if (even[0] == -1 || odd[1] - odd[0] > even[1] - even[0]) {
                longer = odd;
            } else {
                longer = even;
            }
            if (longer[1] - longer[0] > longest[1] - longest[0]) {
                longest[0] = longer[0];
                longest[1] = longer[1];
            }
        }

        return s.substring(longest[0], longest[1] + 1);
    }

    private int[] checkPalindrome(String s, int i, int j) {
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
