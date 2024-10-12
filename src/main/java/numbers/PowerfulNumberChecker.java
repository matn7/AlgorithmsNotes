package numbers;

import java.util.ArrayList;
import java.util.List;

public class PowerfulNumberChecker {

    // Liczba n jest potężna, jeśli każdy czynnik pierwszy w jej rozkładzie na czynniki pierwsze występuje co najmniej
    // tak często, jak w najmniejszej potędze występującej w jej rozkładzie.

    // O(sqrt(n) + log(n)) | O(1) space
    // Function to check if a number is a powerful number
    public static boolean isPowerfulNumber(int n) {
        if (n <= 0) {
            return false; // Powerful numbers are positive integers
        }

        // Check for each prime factor
        for (int prime = 2; prime * prime <= n; prime++) {
            int count = 0; // Count the power of prime in n
            while (n % prime == 0) {
                n /= prime;
                count++;
            }
            if (count % 2 != 0) {
                return false; // If the power is not even, it's not powerful
            }
        }

        // If n is still greater than 1, it must be a prime number
        // (since we've divided out all its prime factors)
        if (n > 1) {
            int sqrtN = (int) Math.sqrt(n);
            if (sqrtN * sqrtN != n) {
                return false; // If it's not a perfect square, it's not powerful
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int numberToCheck = 36; // Change this to the number you want to check

        for (int i = 2; i < 100; i++) {
            if (isPowerfulNumber(i)) {
                System.out.println(i + " is a powerful number.");
            }
        }
    }


}