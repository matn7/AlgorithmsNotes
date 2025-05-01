package april_2025;

public class MyAtoi {

    public static void main(String[] args) {
//        String s = "1337c0d3";
//        String s = "-45";
//        String s = "0-1";
        String s = "20000000000000000000";

        MyAtoi myAtoi = new MyAtoi();
        int result = myAtoi.myAtoi(s);
        System.out.println(result);
    }

    public int myAtoi(String s) {
        int stop = 0;
        while (stop < s.length() && (s.charAt(stop) == ' ')) {
            stop++;
        }
        if (stop == s.length()) {
            return 0;
        }

        boolean negative = false;
        if (s.charAt(stop) == '-') {
            stop++;
            negative = true;
        } else if (s.charAt(stop) == '+') {
            stop++;
        }
        if (stop == s.length()) {
            return 0;
        }
        if (!Character.isDigit(s.charAt(stop))) {
            return 0;
        }
        int res = 0;
        long test = 0;
        long pow = 1;
        int i = stop;
        while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
            i++;
        }
        if (i - stop > 9) {
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        while (i >= stop) {
            test += ((long) (s.charAt(i) - '0') * pow);
            if (test > Integer.MAX_VALUE) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res += (int) ((s.charAt(i) - '0') * pow);
            i--;
            pow *= 10;
        }
        return negative ? res * -1 : res;
    }

}
