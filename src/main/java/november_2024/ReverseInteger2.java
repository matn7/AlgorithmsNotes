package november_2024;

public class ReverseInteger2 {

    public int reverse(int x) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        int res = 0;
        while (x != 0) {
            int digit = x % 10;
            x = x / 10;

            // Overflow and underflow checks
            if (res > max / 10 || (res == max / 10 && digit > max % 10)) {
                return 0;
            }
            if (res < min / 10 || (res == min / 10 && digit < min % 10)) {
                return 0;
            }

            res = res * 10 + digit;
        }
        return res;
    }
}
