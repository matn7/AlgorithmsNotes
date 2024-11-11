package november_2024;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UglyNumber {

    public static void main(String[] args) {
        int n = 9;
        UglyNumber uglyNumber = new UglyNumber();
        boolean result = uglyNumber.isUgly(n);
        System.out.println(result);
    }

    public boolean isUgly(int n) {
        if (n <= 1) {
            return false;
        }
        Map<Integer, Integer> factors = new HashMap<>();

        while (n % 2 == 0) {
            factors.put(2, factors.getOrDefault(2, 0) + 1);
            n = n / 2;
        }

        // skip even
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                n = n / i;
            }
        }

        if (n > 2) {
            factors.put(n, 1);
        }

        Set<Integer> allowedFactors = new HashSet<>();
        allowedFactors.add(2);
        allowedFactors.add(3);
        allowedFactors.add(5);

        for (Map.Entry<Integer, Integer> factor : factors.entrySet()) {
            if (!allowedFactors.contains(factor.getKey())) {
                return false;
            }
        }

        return true;
    }

}
