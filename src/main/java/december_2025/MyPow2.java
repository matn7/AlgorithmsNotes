package december_2025;

public class MyPow2 {

    public static void main(String[] args) {
//        double x = 2.00000;
//        int n = 10;

//        double x = 2.10000;
//        int n = 3;

        double x = 2.00000;
        int n = -2;

        MyPow2 myPow2 = new MyPow2();
        double result = myPow2.myPow(x, n);
        System.out.println(result);
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 1) {
            return x;
        }

        return n < 0 ? 1 / helper(x, (long) -1 * n) : helper(x, (long) n);
    }

    private double helper(double x, long n) {
        if (n == 1) {
            return x;
        }
        double half = helper(x, n / 2);

        return n % 2 != 0 ? x * half * half : half * half;
    }

}
