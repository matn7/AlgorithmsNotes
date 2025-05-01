package april_2025;

public class PalindromeNumber {

    public static void main(String[] args) {
        int x = 10;

        PalindromeNumber palindromeNumber = new PalindromeNumber();
        boolean result = palindromeNumber.isPalindrome(x);
        System.out.println(result);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int y = x;
        int pow = 1;
        while (y >= 10) {
            pow *= 10;
            y = y / 10;
        }

        int sum = 0;
        y = x;
        while (y > 0) {
            int n = y % 10;
            sum += (n * pow);
            y = y / 10;
            pow = pow / 10;
        }

        return sum == x;
    }

    /*
            int res = 0;
        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            res |= bit << (31 - i);
        }
        return res;

     */

}
