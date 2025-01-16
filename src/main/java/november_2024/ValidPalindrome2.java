package november_2024;

import java.util.Locale;

public class ValidPalindrome2 {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
//        String s = "0P";

        ValidPalindrome2 validPalindrome2 = new ValidPalindrome2();
        boolean palindrome = validPalindrome2.isPalindrome(s);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(String s) {
        String lowerCase = s.toLowerCase();
        int first = 0;
        int last = lowerCase.length() - 1;

        while (first < last) {
//            while (first < last && !Character.isAlphabetic(lowerCase.charAt(first))
//                    && !Character.isDigit(lowerCase.charAt(first))) {
//                first++;
//            }
//            while (last > first && !Character.isAlphabetic(lowerCase.charAt(last))
//                    && !Character.isDigit(lowerCase.charAt(last))) {
//                last--;
//            }
            while (first < last && !alphaNum(s.charAt(first))) {
                first++;
            }
            while (last > first && !alphaNum(s.charAt(last))) {
                last--;
            }
            if (lowerCase.charAt(first) != lowerCase.charAt(last)) {
                return false;
            }
            first++;
            last--;
        }
        return true;
    }

    private boolean alphaNum(char c) {
        int i = (int) c;
        return (i >= (int) 'A' && i <= (int) 'Z') || (i >= (int) 'a' && i <= (int) 'z') ||
                (i >= (int) '0' && i <= (int) '9');
    }

}
