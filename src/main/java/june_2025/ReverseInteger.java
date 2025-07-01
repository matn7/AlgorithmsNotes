package june_2025;

public class ReverseInteger {

    // O(1) time | O(1) space
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int digit = x % 10;
            x = x / 10;
            long test = 10l * res + digit;
            if (test < Integer.MIN_VALUE || test > Integer.MAX_VALUE) {
                return 0;
            }
            res = (int) test;
        }
        return res;
    }

}
