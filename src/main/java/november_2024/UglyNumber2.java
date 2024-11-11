package november_2024;

import java.util.Arrays;
import java.util.List;

public class UglyNumber2 {

    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        List<Integer> primes = Arrays.asList(2, 3, 5);

        for (int p : primes) {
            while (n % p == 0) {
                n = n / p;
            }
        }
        return n == 1;
    }

}
