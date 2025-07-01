package june_2025;

public class MyPow3 {

    public static void main(String[] args) {

        double x = 2.0;
        int n = 10;
        MyPow3 myPow3 = new MyPow3();
        double result = myPow3.myPow(x, n);
        System.out.println(result);

    }

    // O(log(n)) time | O(log(n)) space
    public double myPow(double x, int n) {
        if (x == 1.0) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        return n > 0 ? helper(x, (long) n) : 1 / helper(x, (long) -1 * n);
    }

    private double helper(double x, long n) {
        if (n == 1) {
            return x;
        }
        double half = helper(x, n / 2);
        return n % 2 == 0 ? half * half : x * half * half;
    }

}
