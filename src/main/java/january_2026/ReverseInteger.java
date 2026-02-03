package january_2026;

public class ReverseInteger {

    // O(1) time | O(1) space
    public int reverse(int x) {
        int MAX_VAL = Integer.MAX_VALUE;
        int MIN_VAL = Integer.MIN_VALUE;

        int reversedN = 0;

        while (x != 0) {
            int digit = x % 10;
            x = x / 10;

            if (reversedN > MAX_VAL / 10 || reversedN < MIN_VAL / 10) {
                return 0;
            }
            reversedN = reversedN * 10 + digit;
        }
        return reversedN;
    }

}
