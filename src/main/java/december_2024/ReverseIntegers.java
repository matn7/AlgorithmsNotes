package december_2024;

public class ReverseIntegers {

    public static void main(String[] args) {
        int x = 123;

        ReverseIntegers reverseIntegers = new ReverseIntegers();
        int result = reverseIntegers.reverse(x);
        System.out.println(result);
    }

    public int reverse(int x) {
        boolean neg = false;
        if (x < 0) {
            neg = true;
            x = x * (-1);
        }
        int res = 0;
        while (x != 0) {
            int digit = x % 10; // 123 % 100 = 3
            long test = (long) res * 10 + digit;
            if (test > Integer.MAX_VALUE || test < 0) {
                return 0;
            }
            res = (res * 10) + digit; // 0 + 3 * 100
            x = x / 10;
        }
        return neg ? res * (-1) : res;
    }

}
