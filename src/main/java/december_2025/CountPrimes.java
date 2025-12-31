package december_2025;

import java.util.Arrays;

public class CountPrimes {

    public static void main(String[] args) {
        int n = 2;
        CountPrimes countPrimes = new CountPrimes();
        int result = countPrimes.countPrimes(n);
        System.out.println(result);
    }

    // O(n * log(log(n)) time | O(n) space
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] sieve = getSieve(n);
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (sieve[i]) {
                count++;
            }
        }
        return count;
    }

    private boolean[] getSieve(int n) {
        boolean[] sieve = new boolean[n + 1];
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;

//        for (int i = 2; i <= Math.sqrt(n); i++) {
//            if (sieve[i]) {
//                for (int j = i * 2; j <= n; j += i) {
//                    sieve[j] = false;
//                }
//            }
//        }
        for (int i = 2; i <= Math.sqrt(n); i++) {

            if (sieve[i]) {
                for (int j = i*i; j <= n; j += i) {
                    sieve[j] = false;
                }
            }
        }
        return sieve;
    }

}
