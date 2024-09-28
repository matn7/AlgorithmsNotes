package august_2024;

import java.math.BigInteger;

public class Factorial {

    public static void main(String[] args) {
        BigInteger factorial = factorial(5);
        System.out.println(factorial);

        System.out.println(factTail(5));

        System.out.println(factIter(5));
    }

    public static BigInteger factorial(int num) {
        BigInteger fact = BigInteger.ONE;

        for (int i = 1; i <= num; i++) {
            fact = fact.multiply(new BigInteger(String.valueOf(i)));
        }
        return fact;
    }

    // O(n) time | O(1) space
    public static int factTail(int num) {
        return factTailHelper(num, 1);
    }

    private static int factTailHelper(int num, int result) {
        if (num == 0) {
            return result;
        }
        return factTailHelper(num - 1, num * result);
    }

    public static int factIter(int num) {
        int res = 1;
        for (int i = 1; i <= num; i++) {
            res = res * i;
        }
        return res;
    }

}
