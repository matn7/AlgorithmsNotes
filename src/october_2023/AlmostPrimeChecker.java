package october_2023;

import java.util.HashSet;
import java.util.Set;

public class AlmostPrimeChecker {

    public static void main(String[] args) {
        boolean result = isAlmostPrime(18);
        System.out.println(result);
    }

    // O(sqrt(n)) time | O(1) space
    public static boolean isAlmostPrime(int n) {
        int distinctPrimeFactors = countDistinctPrimeFactors(n);
        return distinctPrimeFactors == 2;
    }

    private static int countDistinctPrimeFactors(int n) {
        Set<Integer> primeFactors = new HashSet<>();
        while (n % 2 == 0) {
            primeFactors.add(2);
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                primeFactors.add(i);
                n /= i;
            }
        }

        if (n > 1) {
            primeFactors.add(n);
        }
        return primeFactors.size();
    }

}
