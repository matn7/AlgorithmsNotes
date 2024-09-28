package august_2024;

public class StringToIntegerV2 {

    public static void main(String[] args) {
        String num = "-21059087";

        int result = stringToInteger(num);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int stringToInteger(String num) {
        // 0 1 2 3 4 5 6 7 8
        // - 2 1 0 5 9 0 8 7
        //   e             s
        int res = 0;
        int start = num.length() - 1;
        int end = 0;
        int mul = 1;
        if (num.charAt(0) == '-') {
            end = 1;
            mul = -1;
        }
        int pow = 0;

        while (start >= end) {
            char currNum = num.charAt(start);
            int currNumVal = currNum - '0'; // 9 * 1000
            int currSum = (int) (currNumVal * Math.pow(10, pow));
            res += currSum; // 9087
            start--;
            pow++;
        }

        return res * mul;
    }

}
