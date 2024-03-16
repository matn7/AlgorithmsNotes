package october_2023;

import java.util.ArrayList;
import java.util.List;

public class PowerfulNumberV2 {

    public static void main(String[] args) {
        int n = 75;
        System.out.println(powerfulNumber(0, 100));
    }

    // O(n) time | O(n) space
    public static List<Integer> powerfulNumber(int start, int end) {

        List<Integer> primes = generatePrimes(end);
        List<Integer> powerfulNums = new ArrayList<>();

        for (int n = primes.get(0); n <= end; n++) {
            List<Integer> primeDivisors = new ArrayList<>();
            for (Integer prime : primes) {
                if (n % prime == 0) {
                    primeDivisors.add(prime);
                }
            }
            if (primeDivisors.isEmpty()) {
                continue;
            }
            int count = primeDivisors.size();
            for (Integer elem : primeDivisors) {
                int square = elem * elem;
                if (n % square == 0) {
                    count--;
                }
            }
            if (count == 0) {
                powerfulNums.add(n);
            }
        }

        return powerfulNums;
    }

    private static List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n / 2; i++) {
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

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
