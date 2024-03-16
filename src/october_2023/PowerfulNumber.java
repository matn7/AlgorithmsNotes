package october_2023;

import java.util.ArrayList;
import java.util.List;

public class PowerfulNumber {

    public static void main(String[] args) {
        List<Integer> powerfulNums = powerfulNumberChecker(1, 100);
        System.out.println(powerfulNums);
    }

    // O(n) time | O(n) space
    public static List<Integer> powerfulNumberChecker(int start, int end) {
        List<Integer> primes = generatePrimes(end);
        List<Integer> result = new ArrayList<>();

        for (int num = start; num <= end; num++) {
            // 36
            List<Integer> divByPrimes = new ArrayList<>();
            for (Integer prime : primes) {
                if (num % prime == 0) {
                    divByPrimes.add(prime);
                }
            }
            if (divByPrimes.size() == 0) {
                continue;
            }
            int counter = divByPrimes.size();
            for (Integer prime : divByPrimes) {
                int square = prime * prime;
                if (num % square == 0) {
                    counter--;
                }
            }
            if (counter == 0) {
                System.out.println(num + " : is Powerful");
                result.add(num);
            }
        }

        return result;
    }

    private static List<Integer> generatePrimes(int end) {
        List<Integer> primes = new ArrayList<>();
//        for (int num = 2; num < Math.sqrt(end); num++) {
        for (int num = 2; num <= end; num++) {
            // 2
            if (isPrime(num)) {
                primes.add(num);
            }
        }
        return primes;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


}
