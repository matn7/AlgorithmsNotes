package july_2025;

import java.util.HashMap;
import java.util.Map;

public class PrimeFactors {

    // Intuition:
    // - prime div by itself and 1
    // - how to check all prime factors for single num
    // Approach:
    // - prime factor algo
    // - check freq of primes
    // - return size of freq map
    // Complexity:
    // - O(k * log(m)) time | O(m / log(m)) space
    // Code:

    public int distinctPrimeFactors(int[] nums) {
        Map<Integer, Integer> primesFreq = new HashMap<>();
        for (int num : nums) { // O(n)
            while (num % 2 == 0) { // O(log(n))
                primesFreq.put(2, primesFreq.getOrDefault(2, 0) + 1);
                num = num / 2;
            }

            for (int i = 3; i <= Math.sqrt(num); i += 2) { // O(sqrt(n))
                while (num % i == 0) {
                    primesFreq.put(i, primesFreq.getOrDefault(i, 0) + 1);
                    num = num / i;
                }
            }

            if (num != 1) {
                primesFreq.put(num, 1);
            }
        }
        return primesFreq.size();
    }

}
