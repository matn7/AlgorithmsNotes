package november_2024;

public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        palindromeNumber.isPalindrome(1001);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int pow = 1;
        int y = x;
        while (y >= 10) {
            pow *= 10;
            y = y / 10;
        }

        y = x;
        int num = 0;
        while (y > 0) {
            int n = y % 10;
            num += (n * pow);
            y = y / 10;
            pow /= 10;
        }
        return num == x;
    }

}
