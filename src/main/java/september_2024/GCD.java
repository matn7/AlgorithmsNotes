package september_2024;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GCD {

    public static void main(String[] args) {
        int a = 48;
        int b = 180;

        Map<Integer, Integer> aFactors = primeFactors(a);
        Map<Integer, Integer> bFactors = primeFactors(b);

        System.out.println(aFactors);
        System.out.println(bFactors);

        int gcd = gcd(a, b);
        System.out.println(gcd);

    }

    public static Map<Integer, Integer> primeFactors(int num) {
        Map<Integer, Integer> factors = new HashMap<>();

        while (num % 2 == 0) {
            factors.put(2, factors.getOrDefault(2, 0) + 1);
            num = num / 2;
        }

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            while (num % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                num = num / i;
            }
        }

        if (num > 2) {
            factors.put(num, 1);
        }

        return factors;
    }

    public static int gcd(int a, int b) {
        Map<Integer, Integer> aFactors = primeFactors(a);
        Map<Integer, Integer> bFactors = primeFactors(b);

        int gcd = 1;
        for (Integer prime : aFactors.keySet()) {
            if (bFactors.containsKey(prime)) {
                gcd *= Math.pow(prime, Math.min(aFactors.get(prime), bFactors.get(prime)));
            }
        }

        return gcd;
    }

}
