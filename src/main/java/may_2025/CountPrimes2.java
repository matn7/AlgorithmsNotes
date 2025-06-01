package may_2025;

import java.util.Arrays;

public class CountPrimes2 {

    public static void main(String[] args) {
        int n = 2;

        CountPrimes2 countPrimes2 = new CountPrimes2();
        int result = countPrimes2.countPrimes(n);
        System.out.println(result);
    }

    public int countPrimes(int n) {
        boolean[] primes = sieve(n);
        int count = 0;
        for (int i = 0; i <= n; i++) {
            if (primes[i]) {
                count++;
            }
        }
        return count;
    }

    private boolean[] sieve(int n) {
        boolean[] primes = new boolean[n + 1];
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
