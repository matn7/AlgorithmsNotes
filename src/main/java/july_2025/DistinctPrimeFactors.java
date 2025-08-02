package july_2025;

import java.util.HashMap;
import java.util.Map;

public class DistinctPrimeFactors {

    // O(k * sqrt(m)) time | O(m / log(m)) space
    public int distinctPrimeFactors(int[] nums) {
        Map<Integer, Integer> primes = new HashMap<>();

        for (int num : nums) {
            while (num % 2 == 0) {
                primes.put(2, primes.getOrDefault(2, 0) + 1);
                num = num / 2;
            }

            for (int i = 3; i <= Math.sqrt(num); i++) {
                while (num % i == 0) {
                    primes.put(i, primes.getOrDefault(i, 0) + 1);
                    num = num / i;
                }
            }

            if (num != 1) {
                primes.put(num, primes.getOrDefault(num, 0) + 1);
            }
        }
        return primes.size();
    }

}
