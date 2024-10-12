package august_2024;

import java.util.Arrays;

public class CountPrimesV2 {

    public static void main(String[] args) {

        int result = countPrimes(100);
        System.out.println(result);

    }

    // O(n) time | O(n) space
    public static int countPrimes(int end) {

        boolean[] sieve = sieve(end);
        int count = 0;
        for (int i = 0; i <= end; i++) {
            if (sieve[i]) {
                System.out.println(i + " is a prime number");
                count++;
            }
        }
        return count;

    }

    private static boolean[] sieve(int num) {
        boolean[] sieve = new boolean[num + 1];

        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (sieve[i]) {
                for (int j = i * 2; j <= num; j += i) {
                    sieve[j] = false;
                }
            }
        }

        return sieve;
    }

}
