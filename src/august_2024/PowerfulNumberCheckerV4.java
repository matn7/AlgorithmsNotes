package august_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerfulNumberCheckerV4 {

    public static void main(String[] args) {

        List<Integer> integers = powerfulNumbers(0, 100);
        System.out.println(integers);

        System.out.println(powerfulNumbersV2(0, 100));
    }

    public static List<Integer> powerfulNumbersV2(int start, int end) {
        List<Integer> result = new ArrayList<>();
        for (int num = start; num <= end; num++) {
            if (isPowerfulNumber(num)) {
                result.add(num);
            }
        }
        return result;
    }

    private static boolean isPowerfulNumber(int n) {
        if (n <= 3) {
            return false;
        }
        for (int prime = 2; prime * prime <= n; prime++) {
            int count = 0;
            while (n % prime == 0) {
                n /= prime;
                count++;
            }
            if (count % 2 != 0) {
                return false;
            }
            if (n > 1) {
                int sqrtN = (int) Math.sqrt(n);
                if (sqrtN * sqrtN != n) {
                    return false;
                }
            }
        }
        return true;
    }

    // O(n*Math.sqrt(n) + (end - start)*Math.sqrt(n)) time | O(n / log(n)) space
    public static List<Integer> powerfulNumbers(int start, int end) {
        List<Integer> result = new ArrayList<>();

        boolean[] primes = sieve(end);

        for (int num = start; num <= end; num++) {
            List<Integer> divisors = new ArrayList<>();
            for (int i = 0; i <= num / 2; i++) {
                if (primes[i] && num % i == 0) {
                    divisors.add(i);
                }
            }
            int count = divisors.size();
            if (count == 0) {
                continue;
            }
            for (int div : divisors) {
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

    private static boolean[] sieve(int num) {
        boolean[] sieve = new boolean[num + 1];
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;

        for (int i = 2; i < Math.sqrt(num); i++) {
            if (sieve[i]) {
                for (int j = i * 2; j <= num; j += i) {
                    sieve[j] = false;
                }
            }
        }
        return sieve;
    }

}
