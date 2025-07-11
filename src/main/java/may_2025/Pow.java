package may_2025;

public class Pow {

    public static void main(String[] args) {
        double x = 2.0;
        int n = 10;
        Pow pow = new Pow();
        double result = pow.myPow(x, n);
        System.out.println(result);
    }

    public double myPow(double x, int n) {
        double res = helper(x, Math.abs(n));
        return n < 0 ? 1 / res : res;
    }

    private double helper(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1.0;
        }
        double res = helper(x, n / 2);
        return n % 2 == 0 ? res * res : x * res * res;
    }

}
