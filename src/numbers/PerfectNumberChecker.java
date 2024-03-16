package numbers;

public class PerfectNumberChecker {

    // Liczba doskonała to liczba całkowita, która jest równa sumie swoich dzielników własnych (wyłączając siebie).

    // O(sqrt(n)) time | O(1) space
    // Function to check if a number is perfect
    public static boolean isPerfectNumber(int n) {
        if (n <= 1) {
            return false; // Perfect numbers are positive integers greater than 1
        }

        int sum = 1; // Start with 1 as it is always a divisor

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) {
                    sum += n / i;
                }
            }
            System.out.println(sum);
        }

        return sum == n;
    }

    public static void main(String[] args) {
        int numberToCheck = 28; // Change this to the number you want to check

        if (isPerfectNumber(numberToCheck)) {
            System.out.println(numberToCheck + " is a perfect number.");
        } else {
            System.out.println(numberToCheck + " is not a perfect number.");
        }
    }
}