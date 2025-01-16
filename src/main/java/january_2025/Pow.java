package january_2025;

public class Pow {

    public static void main(String[] args) {
        Pow pow = new Pow();
        double result = pow.myPow(2, -2);
        System.out.println(result);
    }

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        double res = helper(x, n);
        return n < 0 ? 1 / res : res;
    }

    private double helper(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = helper(x, n / 2);
        return (n % 2 == 0) ? half * half : x * half * half;
    }

}
