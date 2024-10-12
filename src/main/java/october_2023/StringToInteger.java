package october_2023;

public class StringToInteger {

    public static void main(String[] args) {
        String value = "-21302";
        System.out.println(stringToInteger(value));
    }

    // O(n) time | O(1) space
    public static int stringToInteger(String value) {
        int startIdx = 0;
        boolean isNegative = false;
        if (value.charAt(0) == '-') {
            startIdx = 1;
            isNegative = true;
        }
        int sum = 0;
        int wordLength = value.length() - startIdx; // 4
        int pow = 1;
        for (int i = 0; i < wordLength; i++) {
            char c = value.charAt(startIdx); // 2
            int cVal = c - '0';
            int currValue = (int) (cVal * Math.pow(10, wordLength - pow));
            sum += currValue;
            startIdx++;
            pow++;
        }
        if (isNegative) {
            return -1 * sum;
        }
        return sum;
    }



}
