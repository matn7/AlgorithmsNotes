package january_2024;

public class StringToInteger {

    public static void main(String[] args) {
        int result = convertToInt("-105");
        System.out.println(result + 1);
    }

    // O(n) time | O(1) space
    public static int convertToInt(String str) {
        boolean isNegative = false;
        int startIdx = 0;

        if (str.charAt(0) == '-') {
            isNegative = true;
            startIdx = 1;
        }

        int result = 0;

        for (int i = startIdx; i < str.length(); i++) {
            char c = str.charAt(i);
            result = result * 10 + (int) c - (int) '0';
        }

        if (isNegative) {
            result *= -1;
        }

        return result;
    }

}
