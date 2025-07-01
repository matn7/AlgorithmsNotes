package june_2025;

import java.util.HashMap;
import java.util.Map;

public class DistinctPrimeFactor {

    public static void main(String[] args) {
//        int[] nums = {2,4,3,7,10,6};
        int[] nums = {2,14,19,19,5,13,18,10,15,20};
        DistinctPrimeFactor distinctPrimeFactor = new DistinctPrimeFactor();
        int result = distinctPrimeFactor.distinctPrimeFactors(nums);
        System.out.println(result);
    }

    // O(k * log(M)) time | O(M/log(M)) space
    public int distinctPrimeFactors(int[] nums) {
        Map<Integer, Integer> primes = new HashMap<>();

        for (int num : nums) {
            while (num % 2 == 0) {
                primes.put(2, primes.getOrDefault(2, 0) + 1);
                num = num / 2;
            }

            for (int i = 3; i <= Math.sqrt(num); i += 2) {
                while (num % i == 0) {
                    primes.put(i, primes.getOrDefault(i, 0) + 1);
                    num = num / i;
                }
            }
            if (num != 1) {
                primes.put(num, 1);
            }
        }
        return primes.size();
    }


}
