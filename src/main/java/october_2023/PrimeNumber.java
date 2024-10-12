package october_2023;

public class PrimeNumber {

    public static void main(String[] args) {
        int n = 73;

        for (int i = 2; i < 100; i++) {
            if (isPrime(i)) {
                System.out.println(i + " is prime number");
            }
        }
    }

    // O(sqrt(n)) time | O(1) space
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
