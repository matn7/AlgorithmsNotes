package numbers;

public class NobleNumberChecker {
    // Function to check if a number is a Noble Number
    public static boolean isNobleNumber(int n) {
        int oddSum = 0;
        int evenSum = 0;
        int position = 1;  // Initialize the position to 1 for the rightmost digit

        while (n > 0) {
            int digit = n % 10;  // Get the rightmost digit

            // Add the digit to the appropriate sum based on its position
            if (position % 2 == 1) {
                oddSum += digit;
            } else {
                evenSum += digit;
            }

            // Move to the next position and remove the rightmost digit
            position++;
            n /= 10;
        }

        // Check if the absolute difference between the sums is 1
        return Math.abs(oddSum - evenSum) == 1;
    }

    public static void main(String[] args) {
        int numberToCheck = 1234; // Change this to the number you want to check

        for (int i = 2; i < 100; i++) {
            if (isNobleNumber(i)) {
                System.out.println(i + " is a Noble Number.");
            }
        }
    }
}