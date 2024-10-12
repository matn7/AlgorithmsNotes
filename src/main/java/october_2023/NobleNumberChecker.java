package october_2023;

public class NobleNumberChecker {

    public static void main(String[] args) {

        for (int num = 45; num <= 100; num++) {
            if (isNobleNumber(num)) {
                System.out.println(num + " is a nobel num");
            }
        }

    }

    // O(num of digits in n) time | O(1) space
    public static boolean isNobleNumber(int n) {
        int oddSum = 0;
        int evenSum = 0;
        int position = 1;

        while (n > 0) {
            int digit = n % 10; // Get the right most digit
            if (position % 2 == 1) {
                oddSum += digit;
            } else {
                evenSum += digit;
            }
            position++;
            n /= 10;
        }

        return Math.abs(oddSum - evenSum) == 1;
    }

}
