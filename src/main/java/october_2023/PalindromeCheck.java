package october_2023;

public class PalindromeCheck {

    public static void main(String[] args) {
        String str = "abcdcba";
        System.out.println(isPalindrome(str));
    }

    // O(n) time | O(1) space
    public static boolean isPalindrome(String str) {
        // Write your code here.
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            while (start < end && str.charAt(start) == ' ') {
                start++;
            }
            while (end >= 0 && str.charAt(end) == ' ') {
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
        // Write your code here.
        if (str.length() <= 1) {
            return true;
        }
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }
        return isPalindromeRec(str.substring(1, str.length() - 1));
    }

}
