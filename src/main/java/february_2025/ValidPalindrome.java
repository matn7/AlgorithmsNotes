package february_2025;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
//        String s = " ";
//        String s = "0P";

        ValidPalindrome validPalindrome = new ValidPalindrome();
        boolean palindrome = validPalindrome.isPalindrome(s);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int L = 0;
        int R = s.length() - 1;

        while (L <= R) {
            while (L < chars.length && !Character.isLetterOrDigit(chars[L])) {
                L++;
            }
            while (R >= 0 && !Character.isLetterOrDigit(chars[R])) {
                R--;
            }
            if (L < s.length() - 1 && R >= 0 && Character.toLowerCase(chars[L]) != Character.toLowerCase(chars[R])) {
                return false;
            }
            L++;
            R--;
        }
        return true;
    }

}
