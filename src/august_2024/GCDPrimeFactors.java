package august_2024;

import java.util.HashMap;
import java.util.Map;

public class GCDPrimeFactors {

    public static void main(String[] args) {

        Map<Integer, Integer> integerIntegerMap = primeFactors(180);
        System.out.println();
    }

    // O(Math.sqrt(n) * log(n)) time | O(log(n)) space
    public static Map<Integer, Integer> primeFactors(int n) {
        Map<Integer, Integer> factors = new HashMap<>();

        while (n % 2 == 0) {
            factors.put(2, factors.getOrDefault(2, 0) + 1);
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }
        if (n > 2) {
            factors.put(n, 1);
        }
        return factors;
    }

    // O(sqrt(a) * log(a) + sqrt(b) * log(b)) time | O(log(a) + log(b)) space
    public static int gcdUsingPrimeFactors(int a, int b) {
        Map<Integer, Integer> factorsA = primeFactors(a);
        Map<Integer, Integer> factorsB = primeFactors(b);
        int gcd = 1;

        for (int prime : factorsA.keySet()) {
            if (factorsB.containsKey(prime)) {
                gcd *= Math.pow(prime, Math.min(factorsA.get(prime), factorsB.get(prime)));
            }
        }

        return gcd;
    }


}
