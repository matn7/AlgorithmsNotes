package may_2025;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DistinctPrimesFactors {

    public static void main(String[] args) {
        int[] nums = {2,14,19,19,5,13,18,10,15,20};
        DistinctPrimesFactors distinctPrimesFactors = new DistinctPrimesFactors();
        int result = distinctPrimesFactors.distinctPrimeFactors(nums);
        System.out.println(result);
    }

    // O(n*sqrt(m)) time | O(p) space
    // n - len of nums
    // m - max in nums
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> primeSet = new HashSet<>();

        for (int n : nums) {
            primeSet.addAll(primeFactors(n));
        }

        return primeSet.size();
    }

    public Set<Integer> primeFactors(int num) {
        Set<Integer> result = new HashSet<>();

        while (num % 2 == 0) {
            result.add(2);
            num /= 2;
        }

        for (int i = 3; i * i <= num; i += 2) {
            while (num % i == 0) {
                result.add(i);
                num /= i;
            }
        }

        if (num > 1) {
            result.add(num);
        }

        return result;
    }

}
