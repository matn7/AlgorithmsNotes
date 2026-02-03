package january_2026;

public class StrToInt {

    public static void main(String[] args) {
        String s = "442";

        StrToInt strToInt = new StrToInt();
        int result = strToInt.myAtoi(s);
        System.out.println(result);
    }

    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int stop = 0;
        while (stop < s.length() && s.charAt(stop) == ' ') {
            stop++;
        }

        if (stop == s.length()) {
            return 0;
        }

        boolean negative = false;
        if (s.charAt(stop) == '-') {
            negative = true;
            stop++;
        } else if (s.charAt(stop) == '+') {
            stop++;
        }
        int sum = 0;

        while (stop < s.length() && Character.isDigit(s.charAt(stop))) {
            int digit = s.charAt(stop) - '0';

            if (sum > (Integer.MAX_VALUE - digit) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            sum = sum * 10 + digit;
            stop++;
        }
        return negative ? -1 * sum : sum;
    }


}
