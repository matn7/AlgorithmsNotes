package november_2024;

public class MyPow {

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        double result = myPow.myPow(2.0, -2);
        System.out.println(result);
    }

    public double myPow(double x, int n) {
        double res = helper(x, Math.abs(n));
        return n >= 0 ? res : 1 / res;
    }

    private double helper(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        double res = helper(x * x, n / 2);
        return n % 2 != 0 ? x * res : res;
    }

}
