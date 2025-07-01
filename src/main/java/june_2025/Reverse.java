package june_2025;

public class Reverse {

    public static void main(String[] args) {
        int x = -1234;

        Reverse reverse = new Reverse();
        int result = reverse.reverse(x);
        System.out.println(result);
    }

    public int reverse(int x) {

        int res = 0;

        while (x != 0) {
            int digit = x % 10;
            x = x / 10;
            long test = 10L * res + digit;
            if (test > Integer.MAX_VALUE || test < Integer.MIN_VALUE) {
                return 0;
            }
            res = (int) test;
        }

        return res;
    }

}
