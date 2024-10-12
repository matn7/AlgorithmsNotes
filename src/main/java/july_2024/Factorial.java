package july_2024;

import java.math.BigInteger;

public class Factorial {

    public static void main(String[] args) {
        BigInteger factorial = factorial(123);
        System.out.println(factorial);
    }

    public static  BigInteger factorial(long n) {
        BigInteger tempResult = BigInteger.ONE;

        for (long i = n; i > 0; i--) {
            tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
        }

        return tempResult;
    }

}
