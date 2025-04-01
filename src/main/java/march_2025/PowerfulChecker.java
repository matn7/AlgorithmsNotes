package march_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerfulChecker {

    public static void main(String[] args) {
        // 1, 4, 8, 9, 16, 25, 27, 32, 36, 49, 64, 72, 81, 100,
        int start = 0;
        int end = 100;

        PowerfulChecker powerfulChecker = new PowerfulChecker();
        List<Integer> result = powerfulChecker.powerfulNumbers(start, end);
        System.out.println(result);
    }

    public List<Integer> powerfulNumbers(int start, int end) {
        List<Integer> primes = getPrimes(end);
        List<Integer> result = new ArrayList<>();

        // 36 -> [2, 3]
        // 36 -> [4, 9]

        for (int num = start; num <= end; num++) {
            if (num == 1) {
                result.add(num);
                continue;
            }
            List<Integer> dividable = getDivisable(num, primes);
            int size = dividable.size();
            if (size == 0) {
                continue;
            }
            for (int d : dividable) {
                if (num % (d * d) == 0) {
                    size--;
                }
            }
            if (size == 0) {
                result.add(num);
            }
        }

        return result;
    }

    private List<Integer> getDivisable(int num, List<Integer> primes) {
        List<Integer> result = new ArrayList<>();
        for (Integer prime : primes) {
            if (prime * 2 > num) {
                break;
            }
            if (num % prime == 0) {
                result.add(prime);
            }
        }
        return result;
    }

    // O(nlog(log(n))) time | O(n) space
    private List<Integer> getPrimes(int num) {
        boolean[] prime = new boolean[num];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i < num; i++) {
            if (prime[i]) {
                for (int j = i * 2; j < num; j += i) {
                    prime[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < prime.length; i++) {
            if (prime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

}
