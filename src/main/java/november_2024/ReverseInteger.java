package november_2024;

public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int reverse = reverseInteger.reverse(100);
        System.out.println(reverse);
    }

    public int reverse(int x) {
        boolean negative = x < 0;
        if (negative) {
            x *= -1;

        }
        int y = x;
        int pow = 1;
        while (y >= 10) {
            pow *= 10;
            y = y / 10;
        }

        int reversed = 0;
        while (x > 0) {
            int num = x % 10;
            long test = reversed + ((long) num * pow);
            if (test >= Integer.MAX_VALUE) {
                return 0;
            }
            reversed += num * pow;
            x = x / 10;
            pow /= 10;
        }
        if (negative) {
            reversed *= -1;
        }

        return reversed;
    }

}
