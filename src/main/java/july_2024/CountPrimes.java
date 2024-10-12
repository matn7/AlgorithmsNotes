package july_2024;

import java.util.Arrays;

public class CountPrimes {

    public static void main(String[] args) {
        int result = countPrimes(10);
        System.out.println(result);
    }

    // O(n) time | O(n) space - Erathostenes Sieve
    public static int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        //  0  1  2  3  4  5  6  7  8  9
        // [f, f, t, t, f, t, f, t, f, t]
        //           *
        for (int i = 2; i < Math.ceil(Math.sqrt(n)); i++) {
            if (isPrime[i]) {
                for (int mulIdx = i * 2; mulIdx < n; mulIdx += i) {
                    isPrime[mulIdx] = false;
                }
            }
        }
        int count = 0;
        for (boolean prime : isPrime) {
            if (prime) {
                count++;
            }
        }
        return count;
    }
}
