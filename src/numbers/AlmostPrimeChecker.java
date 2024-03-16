package numbers;

import java.util.HashSet;

public class AlmostPrimeChecker {
    // Function to count the distinct prime factors of a number
    public static int countDistinctPrimeFactors(int n) {
        HashSet<Integer> primeFactors = new HashSet<>();

        // Divide n by 2 until it is odd
        while (n % 2 == 0) {
            primeFactors.add(2);
            n /= 2;
        }

        // Check for prime factors from 3 onwards
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                primeFactors.add(i);
                n /= i;
            }
        }

        // If n is still greater than 1, it's a prime factor
        if (n > 1) {
            primeFactors.add(n);
        }

        // Return the count of distinct prime factors
        return primeFactors.size();
    }

    // O(sqrt(n)) time | O(1) space
    // Function to check if a number is almost prime
    public static boolean isAlmostPrime(int n) {
        int distinctPrimeFactors = countDistinctPrimeFactors(n);

        // An almost prime number has exactly 2 distinct prime factors
        return distinctPrimeFactors == 2;
    }

    public static void main(String[] args) {
        int numberToCheck = 30; // Change this to the number you want to check

        for (int i = 2; i < 20; i++) {
            if (isAlmostPrime(i)) {
                System.out.println(i + " is an almost prime number.");
            } else {
                System.out.println(i + " is not an almost prime number.");
            }
        }
    }
}