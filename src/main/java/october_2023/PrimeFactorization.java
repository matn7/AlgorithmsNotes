package october_2023;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {

    public static void main(String[] args) {
        int num = 9090;
        primeFactorization(num);
    }

    // O(n) time | O(n) space
    public static List<Integer> primeFactorization(int num) {
        List<Integer> result = new ArrayList<>();

        List<Integer> primes = generatePrimes(num);

        for (Integer prime : primes) {
            while (num % prime == 0) {
                result.add(prime);
                num /= prime;
            }
            if (num == 1) {
                break;
            }
        }

        return result;
    }

    private static List<Integer> generatePrimes(int num) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= num / 2; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
