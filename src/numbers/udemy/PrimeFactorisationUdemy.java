package numbers.udemy;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorisationUdemy {

    public static void main(String[] args) {
        List<Long> result = primeFactorizationMy(72);
        factorise(72);
        factorise2(99);
        System.out.println();
    }

    // Brute Force
    // O(n) time | O(1) space
    public static List<Integer> factorise(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n = n / i;
                    result.add(i);
                }
            }
        }

        return result;
    }

    // Optimized Force
    // O(sqrt(n)) time | O(1) space
    public static List<Integer> factorise2(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n = n / i;
                    result.add(i);
                }
            }
        }

        if (n != 1) {
            result.add(n);
        }

        return result;
    }

    public static List<Long> primeFactorizationMy(int n) {
        double sqrt = Math.sqrt(n);
        SieveOfEratosthenes sieve = new SieveOfEratosthenes();
        List<Long> primes = sieve.primeSieve((int) sqrt);
        List<Long> result = new ArrayList<>();

        long currValue = n;
        while (currValue > 1) {
            for (Long prime : primes) {
                if (currValue % prime == 0) {
                    currValue = currValue / prime;
                    result.add(prime);
                    break;
                }
                if (currValue == 1) {
                    break;
                }
            }

        }

        if (currValue != 1) {
            return null;
        }

        return result;
    }

}
