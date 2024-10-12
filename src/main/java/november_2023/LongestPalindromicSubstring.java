package november_2023;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String str = "abaxyzzyxf";

        longestPalindromicSubstring(str);
    }

    // O(n^2) time | O(n) space
    public static String longestPalindromicSubstring(String str) {
        // Write your code here.
        // *
        // a b a x y z z y x f
        if (str.length() <= 1) {
            return str;
        }

        int[] longest = new int[] {-1, -1};
        for (int i = 0; i < str.length() - 1; i++) {
            int[] evenCheck = validPalindrome(str, i, i);
            int[] oddCheck = validPalindrome(str, i, i + 1);
            int[] bigger;
            if (oddCheck[0] == -1) {
                bigger = evenCheck;
            } else if (evenCheck[0] == -1) {
                bigger = oddCheck;
            } else {
                if (evenCheck[1] - evenCheck[0] > oddCheck[1] - oddCheck[0]) {
                    bigger = evenCheck;
                } else {
                    bigger = oddCheck;
                }
            }
            if (bigger[1] - bigger[0] > longest[1] - longest[0]) {
                longest[1] = bigger[1];
                longest[0] = bigger[0];
            }
        }
        return str.substring(longest[0], longest[1]);
    }

    private static int[] validPalindrome(String str, int prev, int next) {
        int[] res = new int[] {-1, -1};
        if (str.charAt(prev) != str.charAt(next)) {
            return res;
        }

        while (prev >= 0 && next < str.length()) {
            char prevChar = str.charAt(prev);
            char nextChar = str.charAt(next);
            if (prevChar != nextChar) {
                break;
            }
            prev--;
            next++;
        }

        res[0] = prev + 1;
        res[1] = next;
        return res;
    }

}
