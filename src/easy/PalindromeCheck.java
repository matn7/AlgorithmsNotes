package easy;

public class PalindromeCheck {

    public static void main(String[] args) {
        String str = "abcdcba";
        isPalindrome(str);
    }

    // OK - repeated 04/03/2022
    // rec("abcdcba")
    // O(n) time | O(1) space
    public static boolean isPalindrome(String str) {
        // Write your code here.
        if (str.length() <= 1) {
            return true;
        }
        //       fl
        // a b c d c b a
        int first = 0;
        int last = str.length() - 1;
        for (int i = 0; i < str.length(); i++) {
            if (first >= last) {
                return true; // true
            }

            if (str.charAt(first) == str.charAt(last)) { // a == a | b == b | c == c
                first++;
                last--;
            } else {
                return false;
            }
        }
        return false;
    }

//    // rec("d)
//    // rec("cdc")
//    // rec("bcdcb")
//    // rec("abcdcba)
//    // O(n) time | O(n) space
//    public static boolean isPalindrome(String str) {
//        // Write your code here.
//        if (str.length() <= 1) {
//            return true;
//        }
//        char first = str.charAt(0); // c
//        char last = str.charAt(str.length() - 1); // c
//        return first == last && isPalindrome(str.substring(1,str.length()-1));
//        // true && true && true && true
//    }

}
