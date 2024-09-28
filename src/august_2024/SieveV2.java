package august_2024;

import java.util.Arrays;

public class SieveV2 {

    public static void main(String[] args) {
        boolean[] sieve = sieve(100);
        for (int i = 0; i <= 100; i++) {
            if (sieve[i]) {
                System.out.println(i + " is a prime number");
            }
        }
    }

    // O(n log(log(n))) time | O(n) space
    public static boolean[] sieve(int num) {
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
