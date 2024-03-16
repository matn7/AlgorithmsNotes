package november_2023;

import java.util.Map;

public class CheckPrime {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    // O(sqrt(n)) time | O(1) space
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int n = 2; n <= Math.sqrt(num); n++) {
            if (num % n == 0) {
                return false;
            }
        }

        return true;
    }

}
