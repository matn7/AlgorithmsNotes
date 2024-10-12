package september_2024;

public class CheckPalindrome {

    public static void main(String[] args) {
        String s = "bb";
        CheckPalindrome checkPalindrome = new CheckPalindrome();
        String result = checkPalindrome.longestPalindrome(s);
        System.out.println(result);
    }

    // leetcode 5

    // O(n^2) time | O(n) space
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int[] res = {0, 0};

        for (int idx = 0; idx < s.length() - 1; idx++) {
            int[] oddPalindrome = checkPalindrome(idx, idx, s);
            int[] evenPalindrome = checkPalindrome(idx, idx + 1, s);

            int[] bigger;
            if (oddPalindrome[1] - oddPalindrome[0] > evenPalindrome[1] - evenPalindrome[0]) {
                bigger = oddPalindrome;
            } else {
                bigger = evenPalindrome;
            }
            if (bigger[1] - bigger[0] > res[1] - res[0]) {
                res = bigger;
            }
        }

        return s.substring(res[0], res[1] + 1);
    }

    private int[] checkPalindrome(int start, int end, String str) {
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
