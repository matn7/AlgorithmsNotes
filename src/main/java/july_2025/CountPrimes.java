package july_2025;

import java.util.Arrays;

public class CountPrimes {

    public static void main(String[] args) {
        int n = 10;

        CountPrimes countPrimes = new CountPrimes();
        int result = countPrimes.countPrimes(n);
        System.out.println(result);
    }

    // Intuition:
    // - primes - 1 and num divisible
    // - efficient way to get primes
    // - determine primes 0 - n and count
    // Approach:
    // - sieve of Eratosthenes
    // - [0, n)
    // - check range
    // Complexity:
    // - O(nloglog(n)) time | O(n) space
    // Code:

    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] primes = getPrimes(n);
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (primes[i]) {
                count++;
            }
        }

        return count;
    }

    private boolean[] getPrimes(int n) {
        boolean[] sieve = new boolean[n];
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;

        for (int i = 2; i < sieve.length; i++) {
            if (sieve[i]) {
                for (int j = i * 2; j < sieve.length; j += i) {
                    sieve[j] = false;
                }
            }
        }
        return sieve;
    }

}
