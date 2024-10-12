package august_2024;

import java.util.Arrays;

public class CheckPrime {

    public static void main(String[] args) {

//        for (int i = 0; i < 100; i++) {
//            if (isPrime(i)) {
//                System.out.println(i + " is prime");
//            }
//        }

        boolean[] sieve = sieve(100);
        System.out.println();
        for (int i = 0; i < sieve.length; i++) {
            if (sieve[i]) {
                System.out.println(i + " is prime");
            }
        }
    }

    public static boolean[] sieve(int num) {
        boolean[] sieve = new boolean[num];
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;

        for (int i = 2; i < Math.sqrt(num); i++) {
            if (sieve[i]) {
                for (int j = i * 2; j < num; j += i) {
                    sieve[j] = false;
                }
            }
        }

        return sieve;
    }

    // O(sqrt(n)) time | O(1) space
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

}
