package whiteboard;

public class PalindromeCheck3 {

    public static void main(String[] args) {
        String str = "abcdcba";
        isPalindrome(str);
    }

    // O(n) time | O(1) space
    public static boolean isPalindromeIter(String str) {
        // Write your code here.
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // O(n) time | O(log(n)) space
    public static boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }
        int start = 0;
        int end = str.length() - 1;
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindrome(str.substring(start + 1, end));
    }

}
