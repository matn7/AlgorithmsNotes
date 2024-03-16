package numbers;

public class PrimeFactorization {

    public static void main(String[] args) {
        primeFactorization(9090);
    }

    // O(sqrt(n)) time | O(1) space
    public static void primeFactorization(int n) {
        if (n <= 1) {
            System.out.println("Liczba mniejsza lub równa 1 nie ma czynników pierwszych.");
            return;
        }

        while (n % 2 == 0) {
            System.out.print(2 + " ");
            n /= 2;
        }

        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }

        if (n > 1) {
            System.out.print(n);
        }
    }

}
