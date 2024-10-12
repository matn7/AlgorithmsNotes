package september_2024;

public class CatalanNumbers {

    public static void main(String[] args) {
        int result = catalanNumber(10);
        System.out.println(result);

        System.out.println(catalanNumberV2(10));
    }

    // O(2^n) time | O(n) space
    public static int catalanNumber(int num) {
        if (num <= 1) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i <= num - 1; i++) {
            result += catalanNumber(i) * catalanNumber(num - 1 - i);
        }
        return result;
    }

    // O(n) time | O(1) space - n number of digits in num
    public static long catalanNumberV2(int num) {
        long numerator = factorial(2 * num);
        long denominator = factorial(num) * factorial(num + 1);
        return numerator / denominator;
    }

    private static long factorial(int num) {
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
