package october_2025;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        ValidPalindrome validPalindrome = new ValidPalindrome();
        boolean result = validPalindrome.isPalindrome(s);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l <= r) {
            while (l <= r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (r >= l && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (l > r) {
                return true;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
