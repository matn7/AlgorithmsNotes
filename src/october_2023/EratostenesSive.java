package october_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EratostenesSive {

    public static void main(String[] args) {
        List<Integer> sieve = sieve(1000);
        List<Integer> primes = primes(1000);

        System.out.println();
    }

    // O(nloglog(n)) time | O(n) space
    public static List<Integer> sieve(int n) {
        boolean[] sieve = new boolean[n];
        // [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        //
        // [t, t, t, t, f, t, f, t, t, t, t, t, t, t, t, t, t, t, t, t]
        Arrays.fill(sieve, true);
        sieve[2] = true;
        for (int i = 2; i * i <= n; i++) {
            if (sieve[i]) {
                for (int p = i*i; p < n; p += i) {
                    sieve[p] = false;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i < sieve.length; i++) {
            if (sieve[i]) {
                result.add(i);
            }
        }
        return result;
    }

    public static List<Integer> primes(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                result.add(i);
            }
        }

        return result;
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
