package udemy.faang;

public class ValidPalindrome {

    public static void main(String[] args) {
        String string = "A man, a plan, a canal: Panama";

        ValidPalindrome validPalindrome = new ValidPalindrome();
        validPalindrome.validPalindrome(string);
    }

    public boolean validPalindrome(String string) {
        string = string.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int left = 0;
        int right = string.length() - 1;
        while (left <= right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
