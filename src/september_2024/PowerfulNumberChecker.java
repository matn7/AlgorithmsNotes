package september_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerfulNumberChecker {

    public static void main(String[] args) {
        List<Integer> integers = powerfulNumbers(0, 100);
        System.out.println(integers);

        List<Integer> integers2 = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            if (isPowerfulNumber(i)) {
                integers2.add(i);
            }
        }
        System.out.println(integers2);
    }

    public static List<Integer> powerfulNumbers(int start, int end) {
        if (start > end) {
            return null;
        }
        boolean[] primes = sieve(end);
        List<Integer> result = new ArrayList<>();
        for (int num = start; num <= end; num++) {
            if (num == 1) {
                result.add(num);
                continue;
            }
            List<Integer> div = new ArrayList<>();
            for (int j = 0; j <= num / 2; j++) {
                if (primes[j] && num % j == 0) {
                    div.add(j);
                }
            }
            int count = div.size();
            if (count == 0) {
                continue;
            }
            for (int n : div) {
                if (num % (n * n) == 0) {
                    count--;
                }
            }
            if (count == 0) {
                result.add(num);
            }
        }
        return result;
    }

    // O(n log log n) time | O(n) space
    private static boolean[] sieve(int num) {
        boolean[] primes = new boolean[num + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i < Math.sqrt(num); i++) { // O(sqrt(n))
            if (primes[i]) {
                for (int j = 2 * i; j <= num; j += i) { // O(n / i)
                    primes[j] = false;
                }
            }
        }
        return primes;
    }


    // O(sqrt(num)) time | O(1) space
    public static boolean isPowerfulNumber(int num) {
        if (num <= 0) {
            return false;
        }
        for (int prime = 2; prime * prime <= num; prime++) {
            int count = 0;
            while (num % prime == 0) {
                num /= prime;
                count++;
            }
            if (count == 1) {
                return false;
            }
        }
        // If num > 1 at this point, it must be a prime factor greater than sqrt(num)
        return num == 1; // Return true only if num has been fully factored down to 1
    }

}
