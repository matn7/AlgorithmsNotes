package september_2024;

import java.util.HashMap;
import java.util.Map;

public class PrimeFactors {

    public static void main(String[] args) {
        int num = 4180;

        Map<Integer, Integer> result = primeFactors(num);
        System.out.println(result);

        int result2 = gcd(48, 180);
        System.out.println(result2);
    }

    public static Map<Integer, Integer> primeFactors(int num) {
        Map<Integer, Integer> factors = new HashMap<>();

        while (num % 2 == 0) {
            factors.put(2, factors.getOrDefault(2, 0) + 1);
            num /= 2;
        }

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            while (num % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                num /= i;
            }
        }

        if (num > 2) {
            factors.put(num, 1);
        }
        return factors;
    }

    // O(sqrt(a) + sqrt(b)) time | O(log(a) + log(b)) space
    public static int gcd(int a, int b) {
        Map<Integer, Integer> factorsA = primeFactors(a);
        Map<Integer, Integer> factorsB = primeFactors(b);

        int gcd = 1;

        for (Integer prime : factorsA.keySet()) {
            if (factorsB.containsKey(prime)) {
                gcd = gcd * (int) Math.pow(prime,
                        Math.min(factorsA.get(prime), factorsB.get(prime))
                );
            }
        }

        return gcd;
    }

}
