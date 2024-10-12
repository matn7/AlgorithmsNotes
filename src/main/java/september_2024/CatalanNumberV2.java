package september_2024;

public class CatalanNumberV2 {

    public static void main(String[] args) {
        int result = catalanNumber(10);
        System.out.println(result);

        System.out.println(factorial(5));

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

    // O(n) time | O(1) space
    public static long catalanNumberV2(int num) {
        long nominator = factorial(2 * num);
        long denominator = factorial(num + 1) * factorial(num);
        return nominator / denominator;
    }

    private static long factorial(int num) {
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
