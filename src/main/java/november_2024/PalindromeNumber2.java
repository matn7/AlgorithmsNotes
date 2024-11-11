package november_2024;

public class PalindromeNumber2 {

    public static void main(String[] args) {
        PalindromeNumber2 palindromeNumber = new PalindromeNumber2();
        palindromeNumber.isPalindrome(1001);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int div = 1;
        while (x >= 10 * div) {
            div *= 10;
        }

        while (x > 0) {
            int right = x % 10;
            int left = x / div;
            if (left != right) {
                return false;
            }

            x = (x % div) / 10;
            div = div / 100;
        }

        return true;
    }

}
