package january_2026;

public class PalindromeNumber {

    public static void main(String[] args) {
        int x = 121;
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        boolean result = palindromeNumber.isPalindrome(x);
        System.out.println(result);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int num = x;
        long test = 0;
        int sum = 0;
        while (num > 0) {
            test = sum * 10L + (num % 10);
            if (test > Integer.MAX_VALUE) {
                return false;
            }
            sum = (int) test;
            num = num / 10;
        }
        return x == sum;
    }

}
