package august_2024;

public class StringToInteger {

    public static void main(String[] args) {
        String num = "-21059087";

        int result = strToInt(num);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int strToInt(String num) {
        if (num.length() == 0) {
            throw new RuntimeException("Invalid input.");
        }
        int start = num.length() - 1;
        int end = 0;
        int mul = 1;
        if (num.charAt(0) == '-') {
            end = 1;
            mul = -1;
        }
        int result = 0;
        int pow = 0;
        while (start >= end) {
            char sChar = num.charAt(start);
            int sNum = sChar - '0';
            int value = (int) (sNum * Math.pow(10, pow));
            result += value;
            start--;
            pow++;
        }
        return result * mul;
    }

}
