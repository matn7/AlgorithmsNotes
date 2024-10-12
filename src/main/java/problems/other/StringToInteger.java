package problems.other;

public class StringToInteger {

    public static void main(String[] args) {
        String num = "-2105";

        StringToInteger stringToInteger = new StringToInteger();
        stringToInteger.convert_to_int(num);
    }

    // ********
    // * STAR - G *
    // ********

    // O(n) time | O(1) space
    public int convert_to_int(String str) {
        boolean is_negative = false;
        int start_index = 0;
        if (str.charAt(0) == '-') {
            is_negative = true;
            start_index = 1;
        }

        int result = 0;
        for (int i = start_index; i < str.length(); i++) {
            char c = str.charAt(i);
            result = result * 10 + ((int) c - (int) '0');
        }

        if (is_negative) {
            result *= -1;
        }

        return result;
    }

    // O(n) time | O(1) space
    public int stringToInteger(String str) {

        boolean negative = false;
        if (str.charAt(0) == '-') {
            negative = true;
            str = str.substring(1); // this is not optimal
        }

        int length = str.length(); // 3
        int counter = 0;
        int sum = 0;
        while (Math.pow(10, length - 1) >= 1) {
            // 10 ^ 2 = 100
            int mul = (int) Math.pow(10, length - 1);
            char curr = str.charAt(counter); // '1'
            int num = curr - '0';
            sum += num*mul;
            length--;
            counter++;
        }

        if (negative) {
            return sum * (-1);
        }

        return sum;
    }
}
