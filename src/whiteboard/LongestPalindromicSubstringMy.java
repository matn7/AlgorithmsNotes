package whiteboard;

public class LongestPalindromicSubstringMy {

    public static void main(String[] args) {
        String str = "it's highnoon";

        longestPalindromicSubstring(str);
    }

    // O(n^2) time | O(n) space
    public static String longestPalindromicSubstring(String str) {
        // Write your code here.
        if (str.length() <= 1) {
            return str;
        }
        int[] max = new int[] {0, 1};
        for (int i = 0; i < str.length() - 1; i++) {
            int[] oddCheck = isPalindrome(str, i, i);
            int[] evenCheck = isPalindrome(str, i, i + 1);
            int oddLen = oddCheck[1] - oddCheck[0];
            int evenLen = evenCheck[1] - evenCheck[0];
            int[] currMax = new int[2];
            if (oddLen > evenLen) {
                currMax = oddCheck;
            } else {
                currMax = evenCheck;
            }
            if (currMax[1] - currMax[0] > max[1] - max[0]) {
                max[0] = currMax[0];
                max[1] = currMax[1];
            }
        }
        return str.substring(max[0], max[1]);
    }

    // abaxyzzyxf
    private static int[] isPalindrome(String str, int start, int end) {
        int[] result = new int[] {-1, -1};
        if (end > start && str.charAt(start) != str.charAt(end)) {
            return result;
        }
        int left = start - 1;
        int right = end + 1;
        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) != str.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        left = left + 1;
        right = right - 1;
        return new int[] {left, right + 1};
    }

}
