package may_2025;

import java.util.Arrays;

public class CountPrimes {

    public static void main(String[] args) {
        int n = 100;
        CountPrimes countPrimes = new CountPrimes();
        int result = countPrimes.countPrimes(n);
        System.out.println(result);
    }

    // O(nlog(log(n))) time | O(n) space
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] primes = sieve(n);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (primes[i]) {
                count++;
            }
        }
        return count;
    }

    private boolean[] sieve(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                for (int j = i * 2; j < primes.length; j += i) {
                    primes[j] = false;
                }
            }
        }
        return primes;
    }
}
