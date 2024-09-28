package august_2024;

public class StringToIntegerV4 {

    public static void main(String[] args) {
        String num = "-21059087";

        int result = strToInt(num);
        System.out.println(result);
    }

    public static int strToInt(String num) {
        int end = 0;
        int start = num.length() - 1;
        int mul = 1;
        if (num.charAt(0) == '-') {
            end = 1;
            mul = -1;
        }
        int sum = 0;
        int pow = 0;
        while (end <= start) {
            char c = num.charAt(start); // '7'
            int cVal = c - '0'; // 7
            sum += cVal * Math.pow(10, pow);
            pow++;
            start--;
        }
        return sum * mul;
    }

}
