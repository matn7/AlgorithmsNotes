package august_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerfulNumberCheckerV2 {

    public static void main(String[] args) {
        System.out.println(isPowerful(27, 27));
        // [4, 8, 9, 16, 25, 27, 32, 36, 49, 64, 72, 81, 100]
        // [4, 8, 9, 16, 25, 27, 32, 36, 49, 64, 72, 81, 100]
    }

    // O(n*Math.sqrt(n) + (end - start)*Math.sqrt(n)) time | O(n / log(n)) space
    public static List<Integer> isPowerful(int start, int end) {
        List<Integer> primes = getPrimes(end);
        boolean[] sieve = getSieve(end);
        List<Integer> result = new ArrayList<>();

        for (int num = start; num <= end; num++) {
            // 36
            // 2, 3
            // 4, 9
            List<Integer> divisors = new ArrayList<>();
            for (int j = 0; j <= num / 2; j++) {
                if (sieve[j] && num % j == 0) {
                    divisors.add(j);
                }
            }
            int count = divisors.size();
            if (count == 0) {
                continue;
            }
            for (Integer div : divisors) {
                if (num % (div * div) == 0) {
                    count--;
                }
            }
            if (count == 0) {
                result.add(num);
            }
        }

        return result;
    }

    private static boolean[] getSieve(int num) {
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

    private static List<Integer> getPrimes(int num) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
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
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
