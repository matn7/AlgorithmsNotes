package star;

public class StringToInteger {

    public static void main(String[] args) {
        String value = "-2130";

        StringToInteger stringToInteger = new StringToInteger();
        stringToInteger.stringToInteger(value);
    }

    // O(n) time | O(1) space
    public int stringToInteger(String value) {
        int endIdx = 0;
        int mul = 1;
        if (value.charAt(0) == '-') {
            endIdx = 1;
            mul = -1;
        }

        int multiplier = 1;
        int sum = 0;

        for (int i = value.length() - 1; i >= endIdx; i--) {
            char c = value.charAt(i);
            int cVal = (int) c - (int) '0';
            sum = sum + cVal * multiplier;
            multiplier *= 10;
        }
        int result = sum * mul;
        return result;
    }

}
