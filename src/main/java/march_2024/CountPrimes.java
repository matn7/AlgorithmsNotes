package march_2024;

import java.util.Arrays;

public class CountPrimes {

    public static void main(String[] args) {

        System.out.println(countPrimes(10));

        System.out.println(countPrimes2(10));

        sieve(10);

    }

    public static int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
                System.out.println("Prime: " + i);
            }
        }
        return count;
    }

    private static boolean[] sieve(int number) {
        boolean[] sieve = new boolean[number + 1];
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;

        // 0 1 2 3 4 5 6 7 8 9 10
        // t t t t t t t t t t t

        for (int i = 2; i <= Math.sqrt(number); i++) {

            if (sieve[i]) {
                for (int j = i*i; j <= number; j += i) {
                    sieve[j] = false;
                }
            }
        }

        return sieve;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // O(n) time | O(n) space
    private static int countPrimes2(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i < Math.ceil(Math.sqrt(n)); i++) {
            if (isPrime[i]) {
                for (int multiplesOfI = i * 2; multiplesOfI < n; multiplesOfI += i) {
                    isPrime[multiplesOfI] = false;
                }
            }
        }

        int count = 0;
        for (boolean prime : isPrime) {
            if (prime) {
                count++;
            }
        }
        return count;
    }
}
