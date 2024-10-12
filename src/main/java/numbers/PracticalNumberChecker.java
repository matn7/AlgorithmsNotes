package numbers;

import java.util.ArrayList;
import java.util.List;

public class PracticalNumberChecker {

    //
    // Liczba 18 jest uważana za liczbę praktyczną, ponieważ można ją przedstawić jako sumę swoich dzielników własnych.
    // Dzielnikami własnymi liczby są liczby naturalne mniejsze od niej samej, które ją dokładnie dzielą.
    // Dla liczby 18, dzielnikami własnymi są liczby: 1, 2, 3, 6, 9.
    // 18 = 1 + 2 + 3 + 6 + 9

    // O(n) time | O(n) space
    // Function to check if a number is practical
    public static boolean isPracticalNumber(int n) {
        // Create an array to store divisors of n
        List<Integer> divisors = new ArrayList<>();

        // Find divisors of n
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) {
                    divisors.add(n / i);
                }
            }
        }

        // Create a boolean array to track sums
        boolean[] canBeSummed = new boolean[n + 1];
        canBeSummed[0] = true;

        // Calculate which numbers can be expressed as sums of divisors
        for (int divisor : divisors) {
            for (int i = divisor; i <= n; i++) {
                canBeSummed[i] = canBeSummed[i] || canBeSummed[i - divisor];
            }
        }

        // Check if every positive integer less than n can be expressed as a sum
        for (int i = 1; i < n; i++) {
            if (!canBeSummed[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int numberToCheck = 18; // Change this to the number you want to check

        if (isPracticalNumber(numberToCheck)) {
            System.out.println(numberToCheck + " is a practical number.");
        } else {
            System.out.println(numberToCheck + " is not a practical number.");
        }
    }
}