package july_2024;

import java.util.ArrayList;
import java.util.List;

public class PowerfulNumberChecker {

    public static void main(String[] args) {

        List<Integer> result = powerfulNumber(72, 100);
        System.out.println(result);

    }

    // O(n*Math.sqrt(n) + (end - start)*Math.sqrt(n)) time | O(n / log(n)) space
    public static List<Integer> powerfulNumber(int start, int end) {
        List<Integer> result = new ArrayList<>();
        List<Integer> primes = getPrimes(end);

        for (int num = start; num < end; num++) {
            List<Integer> divByPrimes = new ArrayList<>();
            for (int prime : primes) {
                if (prime > num / 2) {
                    break;
                }
                if (num % prime == 0) {
                    divByPrimes.add(prime);
                }
            }
            if (divByPrimes.size() == 0) {
                continue;
            }
            int count = divByPrimes.size();
            for (Integer div : divByPrimes) {
                int divDoubled = div * div;
                if (num % divDoubled == 0) {
                    count--;
                }
            }
            if (count == 0) {
                result.add(num);
            }

        }

        return result;
    }

    // O(Math.sqrt(n)) time | O(n/log(n)) space
    private static List<Integer> getPrimes(int end) {
        List<Integer> primes = new ArrayList<>();
        for (int num = 2; num <= end; num++) {
            //
            if (isPrime(num)) {
                primes.add(num);
            }
        }
        return primes;
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

    // O(sqrt(n) * log(n)) time | O(1) space
    public static boolean isPowerfulNumber(int n) {
        if (n <= 0) {
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

}
