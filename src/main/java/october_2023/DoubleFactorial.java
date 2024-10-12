package october_2023;

public class DoubleFactorial {

    public static void main(String[] args) {
        int n = 6;

        int result = factorial(5); // 5 * fact(4)

        System.out.println(result);
        System.out.println(tailFactorial(5, 1));
        System.out.println(doubleFactorial(n));
        System.out.println(doubleFactorialIterative(n));
    }


    // O(n) time | O(n) space
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    private int factorial2(int num) {
        int result = 1;
        for (int n = 2; n < num + 1; n++) {
            result *= n;
        }
        return result;
    }

    // O(n) time | O(1) space
    public static int tailFactorial(int x, int totalSoFar) {
        if (x == 0) {
            return totalSoFar;
        } else {
            return tailFactorial(x - 1, totalSoFar * x);
        }
    }

    // O(n) time | O(n) space
    public static int doubleFactorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * doubleFactorial(n - 2);
    }

    // O(n) time | O(1) space
    public static int doubleFactorialIterative(int n) {
        int result = 1;
        int step = (n % 2 == 0) ? 2 : 1;
        for (int i = n; i >= 1; i-= step) {
            result *= i;
        }
        return result;
    }


}
