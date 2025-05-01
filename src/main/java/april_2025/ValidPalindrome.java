package april_2025;

import july_2024.CoinChange;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        ValidPalindrome validPalindrome = new ValidPalindrome();
        boolean palindrome = validPalindrome.isPalindrome(s);
        System.out.println(palindrome);
    }

    // O(n) time | O(1) space
    public boolean isPalindrome(String s) {

        int L = 0;
        int R = s.length() - 1;

        while (L < R) {
            while (L < R && !Character.isLetterOrDigit(s.charAt(L))) {
                L++;
            }
            while (R > L && !Character.isLetterOrDigit(s.charAt(R))) {
                R--;
            }
            if (Character.toLowerCase(s.charAt(L)) != Character.toLowerCase(s.charAt(R))) {
                return false;
            }
            L++;
            R--;
        }
        return true;
    }

}
