package august_2024;

import java.util.Arrays;

public class CountPrimes {

    public static void main(String[] args) {
        int result = countPrimes(100);
        System.out.println();
        System.out.println(result);

        System.out.println(countPrimesV2(100));
    }

    public static int countPrimes(int num) {

        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (isPrime(i)) {
                count++;
                System.out.println(i);
            }
        }
        return count;
    }

    private static boolean isPrime(int num) {
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

    // O(n) time | O(n) space
    public static int countPrimesV2(int num) {
        if (num <= 1) {
            return 0;
        }

        boolean[] isPrime = new boolean[num];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i < Math.ceil(Math.sqrt(num)); i++) {
            if (isPrime[i]) {
                for (int mul = i * 2; mul < num; mul += i) {
                    isPrime[mul] = false;
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
