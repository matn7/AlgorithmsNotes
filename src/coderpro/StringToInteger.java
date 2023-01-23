package coderpro;

public class StringToInteger {

    public static void main(String[] args) {
        String num = "-2105";

        StringToInteger stringToInteger = new StringToInteger();
        stringToInteger.convert_to_int(num);
    }

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
}
