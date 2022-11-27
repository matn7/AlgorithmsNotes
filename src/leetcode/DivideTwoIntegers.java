package leetcode;

public class DivideTwoIntegers {

    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        int result = divideTwoIntegers.divide(-2147483648, -3);
        System.out.println(result);
    }

//    public int divide(int dividend, int divisor) {
//        if (dividend == Integer.MIN_VALUE && divisor == -1) {
//            return Integer.MAX_VALUE;
//        }
//
//        boolean dividedNegative = dividend < 0;
//        boolean divisorNegative = divisor < 0;
//
//        int sign = 1;
//        if (dividedNegative && divisorNegative) {
//            dividend = dividend * -1;
//            divisor = divisor * -1;
//        } else if (dividedNegative) {
//            sign = -1;
//            dividend = dividend * -1;
//        } else if (divisorNegative) {
//            sign = -1;
//            divisor = divisor * -1;
//        }
//
//        int result = divideHelper(dividend, divisor, 0);
//        return result * sign;
//    }
//
//    private int divideHelper(int dividend, int divisor, int counter) {
//        if (dividend < divisor) {
//            return counter;
//        }
//
//        return divideHelper(dividend - divisor, divisor, counter + 1);
//    }


    public int divide(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == -1) {
            return (1 << 31) - 1;
        }
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int res = 0;
        int x = 0;
        while (a - b >= 0) {
            for (x = 0; a - (b << x << 1) >= 0; x++);
            res += 1 << x;
            a -= b << x;
        }
        return (dividend > 0) == (divisor > 0) ? res : -res;
    }
}
