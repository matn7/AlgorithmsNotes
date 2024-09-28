package problems.easy;

public class PalindromeCheck {

    public static void main(String[] args) {
        String str = "abcdcba";
        isPalindrome(str);
    }

    // O(n) time | O(1) space
    public static boolean isPalindrome(String str) {
        // Write your code here.
        if (str.length() <= 1) {
            return true;
        }
        int first = 0;
        int last = str.length() - 1;
        for (int i = 0; i < str.length(); i++) {
            if (first >= last) {
                return true;
            }

            if (str.charAt(first) == str.charAt(last)) {
                first++;
                last--;
            } else {
                return false;
            }
        }
        return false;
    }


//    // O(n) time | O(n) space
    public static boolean isPalindromeRecursive(String str) {
        // Write your code here.
        if (str.length() <= 1) {
            return true;
        }
        char first = str.charAt(0);
        char last = str.charAt(str.length() - 1);
        return first == last && isPalindromeRecursive(str.substring(1,str.length()-1));
    }

}
