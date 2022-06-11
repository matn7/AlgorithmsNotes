package whiteboard;

public class PalindromeCheck {

    public static void main(String[] args) {
        boolean result = isPalindrome("abcdcba");
        System.out.println();
    }

    public static boolean isPalindrome(String str) {
        return isPalindromeHelper(str, 0, str.length() - 1);
    }

    private static boolean isPalindromeHelper(String str, int start, int end) {
        if (start < end) {
            return true;
        }
        char firstToCheck = str.charAt(start);
        char secondToCheck = str.charAt(end);
        if (firstToCheck != secondToCheck) {
            return false;
        }
        start = start + 1;
        end = end - 1;
        return isPalindromeHelper(str, start, end);
    }


//    public static boolean isPalindrome(String str) {
//        // Write your code here.
//        int start = 0;
//        int end = str.length() - 1;
//        while (start < end) {
//            char first = str.charAt(start);
//            char second = str.charAt(end);
//            if (first != second) {
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
//    }

}
