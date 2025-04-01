package march_2025;

public class MyAtoI {

    public static void main(String[] args) {
//        String s = "-21059087";
        String s = "-91283472332";

        MyAtoI myAtoI = new MyAtoI();
        int result = myAtoI.myAtoi(s);
        System.out.println(result);
    }

    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int stop = 0;
        // Remove leading whitespaces
        while (stop < s.length() && s.charAt(stop) == ' ') {
            stop++;
        }

        // If we reach the end of the string, it's just whitespaces
        if (stop == s.length()) {
            return 0;
        }

        // Check for sign
        boolean negative = false;
        char signChar = s.charAt(stop);
        if (signChar == '-') {
            negative = true;
            stop++;
        } else if (signChar == '+') {
            stop++;
        }

        int res = 0;
        // Process digits
        while (stop < s.length() && Character.isDigit(s.charAt(stop))) {
            int digit = s.charAt(stop) - '0';

            // Check for overflow and underflow
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            res = res * 10 + digit;
            stop++;
        }

        // Return result with the correct sign
        return negative ? -res : res;
    }

}
