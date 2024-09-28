package august_2024;

public class CatalanNumbers {

    public static void main(String[] args) {
        int factorial = factorial(5);
        System.out.println(factorial);

        int result = catalanRec(5);
        System.out.println(result);
    }

    public static int catalanRec(int n) {
        if (n <= 1) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            res += catalanRec(i) * catalanRec(n - 1 - i);
        }
        return res;
    }

    public static int catalanNumbers(int n) {
        int numerator = factorial(2 * n);
        int denominator = factorial(n) * (n + 1);
        return numerator / denominator;
    }

    private static int factorial(int num) {
        int result = 1;

        for (int i = 1; i <= num; i++) {
            result *= i;
        }

        return result;
    }

}
