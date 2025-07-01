package june_2025;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        ValidPalindrome validPalindrome = new ValidPalindrome();
        boolean result = validPalindrome.isPalindrome(s);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        String lower = s.toLowerCase();

        while (i <= j) {
            while (i < j && !Character.isLetterOrDigit(lower.charAt(i))) {
                i++;
            }
            while (j > i && !Character.isLetterOrDigit(lower.charAt(j))) {
                j--;
            }
            if (lower.charAt(i) != lower.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
