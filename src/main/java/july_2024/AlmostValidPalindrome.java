package july_2024;

public class AlmostValidPalindrome {

    public static void main(String[] args) {

    }

    // O(n) time | O(1) space
    public static boolean isAlmostPalindrome(String s) {
        int left = 0;
        int right = s.length() + 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return validSubPalindrome(s, left + 1, right) || validSubPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean validSubPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
