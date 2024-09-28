package september_2024;

public class FastModularExponentation {

    public static void main(String[] args) {
        int a = 2;
        int b = 10;
        int n = 1000;

        // (a ^ b) % n
        long result = powerMod(a, b, n);
        System.out.println(result);
    }

    // O(log(b)) time | O(1) space
    public static long powerMod(long a, long b, long n) {
        long result = 1;
        a = a % n;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % n;
            }
            b >>= 1;
            a = (a * a) % n;
        }
        return result;
    }

}
