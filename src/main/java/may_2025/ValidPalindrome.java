package may_2025;

public class ValidPalindrome {

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = " ";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        boolean result = validPalindrome.isPalindrome(s);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        int i = 0;
        int j = str.length() - 1;

        while (i <= j) {
            while (i < str.length() && !Character.isLetterOrDigit(str.charAt(i))) {
                i++;
            }
            while (j >= 0 && !Character.isLetterOrDigit(str.charAt(j))) {
                j--;
            }
            if (j < i) {
                return true;
            }
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

}
