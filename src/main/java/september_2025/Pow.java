package september_2025;

public class Pow {

    public static void main(String[] args) {
//        double x = 2.0;
//        int n = 10;

        double x = 2.00000;
        int n = -2;

        Pow pow = new Pow();
        double result = pow.myPow(x, n);
        System.out.println(result);
    }

    // O(log(n)) time | O(log(n)) space
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        return n < 0 ? 1 / helper(x, Math.abs((long) n)) : helper(x, Math.abs((long) n));
    }

    private double helper(double x, long n) {
        if (n == 1) {
            return x;
        }
        double half = helper(x, n / 2);
        return n % 2 == 0 ? half * half : x * half * half;
    }
}
