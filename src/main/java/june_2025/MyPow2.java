package june_2025;

public class MyPow2 {

    public static void main(String[] args) {
        double x = 0.44528;
        int n = -10;

        MyPow2 myPow2 = new MyPow2();
        double result = myPow2.myPow(x, n);
        System.out.println(result);
    }

    // O(log(n)) time | O(log(n)) space
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / helper(x, Math.abs((long) n));
        }
        return helper(x, Math.abs((long) n));
    }

    private double helper(double x, long n) {
        if (n == 1) {
            return x;
        }
        double half = helper(x, n / 2);
        return n % 2 == 0 ? half * half : x * half * half;
    }

}
