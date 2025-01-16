package november_2024;

public class ValidPalindrome {

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
//        String s = "race a car";
//        String s = ".,";
        String s = "0P";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        boolean palindrome = validPalindrome.isPalindrome(s);
        System.out.println(palindrome);
    }

    // A man, a plan, a canal: Panama
    public boolean isPalindrome(String s) {
        String lowerCase = s.toLowerCase();
        int l = 0;
        int r = lowerCase.length() - 1;

        while (l < r) {
            // Skip non-alphanumeric characters from the left side
            while (l < lowerCase.length() && !Character.isLetterOrDigit(lowerCase.charAt(l))) {
                l++;
            }

            // Skip non-alphanumeric characters from the right side
            while (r >= 0 && !Character.isLetterOrDigit(lowerCase.charAt(r))) {
                r--;
            }

            // If pointers have crossed, it's a palindrome
            if (l >= r) {
                return true;
            }

            // Check if characters match (case-insensitive)
            if (lowerCase.charAt(l) != lowerCase.charAt(r)) {
                return false;
            }

            // Move both pointers inward
            l++;
            r--;
        }
        return true;
    }
}
