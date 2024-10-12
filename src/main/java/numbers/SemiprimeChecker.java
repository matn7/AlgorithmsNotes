package numbers;

public class SemiprimeChecker {

    // Liczby semipierwsze (semiprime numbers) to liczby całkowite, które są iloczynem dokładnie dwóch liczb pierwszych.

    public static void main(String[] args) {
        int numberToCheck = 15; // Change this to the number you want to check

        for (int i = 1; i < 25
                ; i++) {
            if (isSemiprime(i)) {
                System.out.println(i + " is a semiprime number.");
            }
        }
    }

    public static boolean isSemiprime(int num) {
        if (num <= 1) {
            return false;
        }

        int factors = 0;
        for (int i = 2; i * i <= num && factors < 2; i++) {
            while (num % i == 0) {
                num /= i;
                factors++;
            }
        }

        if (num > 1) {
            factors++;
        }

        return factors == 2;
    }
}