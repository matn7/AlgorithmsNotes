package june_2025;

public class MyPow {

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        double result = myPow.myPow(2.0, 10);
        System.out.println(result);
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        return n < 1 ? 1 / helper(x, Math.abs((long) n)) : helper(x, Math.abs((long) n));
    }

    private double helper(double x, long n) {
        if (n == 1) {
            return x;
        }
        double half = helper(x, n / 2);
        return n % 2 == 0 ? half * half : x * half * half;
    }

}
