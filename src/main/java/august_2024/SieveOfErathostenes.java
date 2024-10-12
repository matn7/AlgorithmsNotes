package august_2024;

import java.util.Arrays;

public class SieveOfErathostenes {

    public static void main(String[] args) {
        int n = 40;

        boolean[] result = sieve(n);
        System.out.println(result);
        for (int i = 0; i < result.length; i++) {
            if (result[i]) {
                System.out.println(i + " is a prime number");
            }
        }
    }

    // O(nlog(log(n))) time | O(n) space
    public static boolean[] sieve(int n) {
        boolean[] primes = new boolean[n];

        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (primes[i]) {
                for (int j = i * 2; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }

        return primes;

    }

}
