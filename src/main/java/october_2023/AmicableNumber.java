package october_2023;

public class AmicableNumber {

    public static void main(String[] args) {
        boolean result = areAmicable(220, 284);
        System.out.println(result);
    }

    // O(sqrt(n)) time | O(sqrt(n)) space
    public static boolean areAmicable(int a, int b) {
        int sumA = sumOfProperDivisors(a);
        int sumB = sumOfProperDivisors(b);

        return sumA == b && sumB == a && a != b;
    }

    private static int sumOfProperDivisors(int n) {
        int sum = 1;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n/i) {
                    sum += n/i;
                }
            }
        }
        return sum;
    }

}
