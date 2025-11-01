package october_2025;

public class ReverseIntegers {

    public static void main(String[] args) {
        int x = 123;
        ReverseIntegers reverseIntegers = new ReverseIntegers();
        int result = reverseIntegers.reverse(x);
        System.out.println(result);
    }

    // O(1) time | O(1) space
    public int reverse(int x) {
        boolean neg = x < 0;
        if (neg) {
            x = x * (-1);
        }
        int sum = 0;
        while (x > 0) {
            int val = x % 10;
            long test = 10L * sum + val;
            if (test > Integer.MAX_VALUE || test < Integer.MIN_VALUE) {
                return 0;
            }
            sum = 10 * sum + val;
            x = x / 10;
        }

        return neg ? -1 * sum : sum;
    }

}
