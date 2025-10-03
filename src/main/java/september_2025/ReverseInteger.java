package september_2025;

public class ReverseInteger {

    public static void main(String[] args) {
        int x = -1234;

        ReverseInteger reverseInteger = new ReverseInteger();
        int result = reverseInteger.reverse(x);
        System.out.println(result);
    }

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int digit = x % 10;
            long test = res * 10L + digit;
            if (test < Integer.MIN_VALUE || test > Integer.MAX_VALUE) {
                return 0;
            }
            res = res * 10 + digit;

            x = x / 10;
        }
        return res;
    }

}
