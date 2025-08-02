package july_2025;

public class FactorialTrailingZeroes {

    public static void main(String[] args) {
        FactorialTrailingZeroes factorialTrailingZeroes = new FactorialTrailingZeroes();
        int result = factorialTrailingZeroes.trailingZeroes(13);
        System.out.println(result);

        int n = 1932053504;
    }


    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n = n / 5;
            count++;
        }
        return count;
    }

    private int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

}
