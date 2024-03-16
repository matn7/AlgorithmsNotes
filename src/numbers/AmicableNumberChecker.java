package numbers;

import java.util.ArrayList;
import java.util.List;

public class AmicableNumberChecker {
    // Function to calculate the sum of proper divisors of a number
    public static int sumOfProperDivisors(int n) {
        int sum = 1; // Start with 1 as all numbers have 1 as a proper divisor

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) {
                    sum += n / i;
                }
            }
        }

        return sum;
    }

    // O(sqrt(n)) time | O(sqrt(n)) space
    // Function to check if a pair of numbers is amicable
    public static boolean areAmicable(int a, int b) {
        int sumA = sumOfProperDivisors(a);
        int sumB = sumOfProperDivisors(b);

        return sumA == b && sumB == a && a != b;
    }

    public static void main(String[] args) {
        int number1 = 220; // Change these values to the numbers you want to check
        int number2 = 284;

        if (areAmicable(number1, number2)) {
            System.out.println(number1 + " and " + number2 + " are amicable numbers.");
        } else {
            System.out.println(number1 + " and " + number2 + " are not amicable numbers.");
        }
    }
}