package november_2025;

public class Pow {

    public static void main(String[] args) {
        double x = 2.0;
        int n = 10;

        Pow pow = new Pow();
        double result = pow.myPow(x, n);
        System.out.println(result);
    }

    // O(log(n)) time | O(log(n)) space
    public double myPow(double x, int n) {
        return n < 0 ? 1 / helper(x, (long) n * -1) : helper(x, (long) n);
    }

    private double helper(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double half = helper(x, n / 2);

        return n % 2 != 0 ? x * half * half : half * half;
    }

}
