package january_2025;

import java.util.HashMap;
import java.util.Map;

public class MyPow {

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        double result = myPow.myPow(2.0, 5);
        System.out.println(result);

//        double result2 = myPow.myPow(2.0, -200000000);
//        System.out.println(result2);
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        double res = helper(x, Math.abs((long) n));
        return n < 0 ? 1 / res : res;
    }

    private double helper(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double half = helper(x, n / 2);
        return n % 2 == 0 ? half * half : x * half * half;
    }



}
