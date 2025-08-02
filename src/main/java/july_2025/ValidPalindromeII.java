package july_2025;

public class ValidPalindromeII {

    public static void main(String[] args) {
        String s = "abc";
        ValidPalindromeII validPalindromeII = new ValidPalindromeII();
        boolean result = validPalindromeII.validPalindrome(s);
        System.out.println(result);
    }

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        if (i > j) {
            return false;
        }
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
