package whiteboard;

public class PalindromeChackRand {

    public static void main(String[] args) {
        String str = "abcdcba";

        isPalindromeRec(str);
    }

    public static boolean isPalindrome(String str) {
        // Write your code here.
        if (str.length() <= 1) {
            return true;
        }
        int start = 0;
        int end = str.length() - 1;
        while (start <= end) {
            while (str.charAt(start) == ' ') {
                start++;
            }
            while (str.charAt(end) == ' ') {
                end--;
            }
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindromeRec(String str) {
        boolean result = isPalindromeRecHelper(str, 0, str.length() - 1);
        return result;
    }

    private static boolean isPalindromeRecHelper(String str, int start, int end) {
        if (start > end) {
            return true;
        }
        while (str.charAt(start) == ' ') {
            start++;
        }
        while (str.charAt(end) == ' ') {
            end--;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        start++;
        end--;
        return isPalindromeRecHelper(str, start, end);
    }


}
