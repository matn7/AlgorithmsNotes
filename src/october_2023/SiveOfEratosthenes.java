package october_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SiveOfEratosthenes {

    public static void main(String[] args) {
        int n = 20;
        sieve(n);
    }

    // O(sqrt(n)) time | O(1) space
    public static List<Integer> sieve(int n) {
        boolean[] sieve = new boolean[n + 1];
        Arrays.fill(sieve, true);
        sieve[2] = true;
        for (int i = 2; i * i <= n; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= n; j +=i) {
                    sieve[j] = false;
                }
            }
        }
        List<Integer> result = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (sieve[i]) {
                result.add(i);
            }
        }

        return result;
    }

}
