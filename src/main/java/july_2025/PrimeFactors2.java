package july_2025;

import java.util.HashMap;
import java.util.Map;

public class PrimeFactors2 {

    public static void main(String[] args) {
        int[] nums = {2,4,3,7,10,6};
        PrimeFactors2 primeFactors2 = new PrimeFactors2();
        int result = primeFactors2.distinctPrimeFactors(nums);
        System.out.println(result);
    }

    public int distinctPrimeFactors(int[] nums) {
        Map<Integer, Integer> factors = new HashMap<>();

        for (int num : nums) {
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
            if (num != 1) {
                factors.put(num, 1);
            }
        }
        return factors.size();
    }


}
