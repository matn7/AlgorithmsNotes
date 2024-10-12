package august_2024;

public class StringToIntegerV3 {

    // O(n) time | O(1) space
    public static int stringToInteger(String num) {
        if (num == null || num.isEmpty()) {
            throw new NumberFormatException("Invalid input string");
        }

        int res = 0;
        int start = 0;
        int sign = 1;

        // Check for sign
        if (num.charAt(0) == '-') {
            sign = -1;
            start = 1;
        } else if (num.charAt(0) == '+') {
            start = 1;
        }

        // Convert each character to digit and build the integer
        //
        // 2 1 0 5 9 0 8 7 9 0 9 9
        //                     i
        for (int i = start; i < num.length(); i++) {
            char currChar = num.charAt(i); // '9'
            if (currChar < '0' || currChar > '9') {
                throw new NumberFormatException("Invalid character found: " + currChar);
            }

            int digit = currChar - '0'; // 9

            // Check for overflow
            // 2105908790 >
            // 214748363
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                throw new NumberFormatException("Overflow: input string is too large to fit in an integer.");
            }

            res = res * 10 + digit; // 210590879 * 10 + 0 = 2105908790
            // 210590879
        }

        return res * sign;
    }

    public static void main(String[] args) {
        String num = "210590879099";
        System.out.println(stringToInteger(num));
        System.out.println(stringToInteger("2147483647")); // Max int value
        System.out.println(stringToInteger("-2147483648")); // Min int value
        // System.out.println(stringToInteger("2147483648")); // Should throw overflow exception
    }

}
