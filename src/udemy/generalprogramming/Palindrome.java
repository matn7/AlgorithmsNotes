package udemy.generalprogramming;

public class Palindrome {

    public static void main(String[] args) {
        String testString = "mayalayam";

        isPalindrome(testString);
    }

    public static boolean isPalindrome(String testString) {
        // make the comparision case insensitive
        testString = testString.toLowerCase();

        // start at the both ends of the string
        int left = 0;
        int right = testString.length() - 1;

        // the while loop continues till the indices meet or pass each problems.other
        while (left < right) {
            // ignore whitespaces
            while (testString.charAt(left) == ' ') {
                left++;
            }
            while (testString.charAt(right) == ' ') {
                right--;
            }
            // return false if we find a single mismatch
            if (testString.charAt(left) != testString.charAt(right)) {
                return false;
            }
            // moving indices forward and backward
            left++;
            right--;
        }
        // no single mismatch found
        return true;

    }

}
