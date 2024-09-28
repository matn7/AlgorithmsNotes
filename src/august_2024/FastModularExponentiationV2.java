package august_2024;

public class FastModularExponentiationV2 {

    public static void main(String[] args) {
        long a = 2;
        long b = 10;
        long n = 1000;

        System.out.println("Result: " + powerMod(a, b, n));

        double v = Math.pow(a, b) % n;
        System.out.println("Result: " + v);
    }

    public static long powerMod(long a, long b, long n) {
        long result = 1;

        a = a % n;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % n;
            }

            b >>= 1;

            a = (a * a) % n;
            System.out.println();
        }
        return result;
    }


}
