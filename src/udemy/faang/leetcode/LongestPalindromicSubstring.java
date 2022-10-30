package udemy.faang.leetcode;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String str = "babxyzbzyxb";
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        longestPalindromicSubstring.longestPalindrome(str);
    }

    // O(n^2) time | O(n) space
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int[] longest = {0, 0};
        for (int i = 0; i < s.length() - 1; i++) {
            int[] oddPalindrome = isPalindrome(i, i, s);
            int[] evenPalindrome = isPalindrome(i, i + 1, s);
            int[] longer;
            if (oddPalindrome[1] - oddPalindrome[0] > evenPalindrome[1] - evenPalindrome[0]) {
                longer = oddPalindrome;
            } else {
                longer = evenPalindrome;
            }
            if (longest[1] - longest[0] < longer[1] - longer[0]) {
                longest[1] = longer[1];
                longest[0] = longer[0];
            }
        }
        return s.substring(longest[0], longest[1] + 1);
    }

    private int[] isPalindrome(int start, int end, String str) {
        if (str.charAt(start) != str.charAt(end)) {
            return new int[] {start, start};
        }
        while (start >= 0 && end <= str.length() - 1) {
            if (str.charAt(start) != str.charAt(end)) {
                break;
            }
            start--;
            end++;
        }
        start++;
        end--;
        return new int[] {start, end};
    }
    
}
