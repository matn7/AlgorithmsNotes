package december_2025;

public class Pow {

    public static void main(String[] args) {
        Pow pow = new Pow();
        double x = 2.0;
        int n = -2147483648;
        double result = pow.myPow(x, n);
        System.out.println(result);
    }

    // O(log(n)) time | O(log(n)) space
    public double myPow(double x, int n) {
        if (n == 0 || x == 1.0) {
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
