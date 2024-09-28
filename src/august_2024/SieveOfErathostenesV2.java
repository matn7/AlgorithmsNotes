package august_2024;

import java.util.Arrays;

public class SieveOfErathostenesV2 {

    public static void main(String[] args) {
        boolean[] sieve = sieve(100);
        for (int i = 0; i < sieve.length; i++) {
            if (sieve[i]) {
                System.out.println(i + " ia a prime number.");
            }
        }
    }

    // O(n) time | O(n) space
    public static boolean[] sieve(int num) {
        boolean[] primes = new boolean[num];

        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i < Math.sqrt(num); i++) {
            if (primes[i]) {
                for (int j = i * 2; j < num; j += i) {
                    primes[j] = false;
                }
            }
        }

        return primes;
    }

}
