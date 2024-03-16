package october_2023;

import java.util.ArrayList;
import java.util.List;

public class SemiPrime {

    public static void main(String[] args) {
        int start = 0;
        int end = 25;

        List<Integer> result = semiPrimes(start, end);
        System.out.println(result);
    }

    // O(sqrt(n)) time | O(1) space
    public static List<Integer> semiPrimes(int start, int end) {
        List<Integer> result = new ArrayList<>();
        for (int num = start; num < end; num++) {
            if (isSemiPrime(num)) {
                result.add(num);
            }
        }
        return result;
    }

    private static boolean isSemiPrime(int num) {
        if (num <= 1) {
            return false;
        }
        int factors = 0;
        for (int i = 2; i * i <= num && factors < 2; i++) {
            while (num % i == 0) {
                num /= i;
                factors++;
            }
        }
        if (num > 1) {
            factors++;
        }
        return factors == 2;
    }

}
