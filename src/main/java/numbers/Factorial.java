package numbers;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(6));
        System.out.println(doubleFactorial(6));
        System.out.println(doubleFactorialIterative(6));
    }

    // O(n) time | O(n) space
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static int doubleFactorial(int n) {
        // Warunek bazowy: podwójny silnik dla n=0 i n=1 wynosi 1
        if (n == 0 || n == 1) {
            return 1;
        }
        // Wywołanie rekurencyjne dla n-2
        return n * doubleFactorial(n - 2);
    }

    // O(n) time | O(1) space
    public static int factorialIterative(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static int doubleFactorialIterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be a non-negative integer.");
        }

        int result = 1;
        int step = (n % 2 == 0) ? 2 : 1; // Determine the step based on the parity of n

        for (int i = n; i >= 1; i -= step) {
            result *= i;
        }

        return result;
    }
}
