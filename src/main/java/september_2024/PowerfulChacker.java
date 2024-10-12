package september_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerfulChacker {

    public static void main(String[] args) {
        List<Integer> powerful = powerful(0, 100);
        System.out.println(powerful);
        // [1, 4, 8, 9, 16, 25, 27, 32, 36, 49, 64, 72, 81, 100]
        // [1, 4, 8, 9, 16, 25, 27, 32, 36, 49, 64, 72, 81, 100]
    }

    public static List<Integer> powerful(int start, int end) {
        List<Integer> result = new ArrayList<>();
        if (start > end) {
            return result;
        }
        boolean[] primes = sieve(end);

        for (int num = start; num <= end; num++) {
            if (num == 1) {
                result.add(1);
                continue;
            }
            List<Integer> div = new ArrayList<>();
            for (int i = 0; i <= num / 2; i++) {
                if (primes[i] && num % i == 0) {
                    div.add(i);
                }
            }
            int count = div.size();
            if (count == 0) {
                continue;
            }

            for (int d : div) {
                if (num % (d * d) == 0) {
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
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (primes[i]) {
                for (int j = i * 2; j <= num; j += i) {
                    primes[j] = false;
                }
            }
        }
        return primes;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
