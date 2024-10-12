package udemy.faang.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MyAtoi {

    static Set<Character> keys = new HashSet<>();

    static {
        keys.add('1');
        keys.add('2');
        keys.add('3');
        keys.add('4');
        keys.add('5');
        keys.add('6');
        keys.add('7');
        keys.add('8');
        keys.add('9');
        keys.add('0');
    }

    public static void main(String[] args) {
        //  2147483647
        // -2147483648
//        String s = "Mam kotka puszka -21474836-49 i sebastianmka";
//        String s = "42";
//        String s = "               -987";
//        String s = "+-12";
//      String s = "20000000000000000000";
//        String s = "9223372036854775808";
//        String s = "-91283472332";
        String s = "  0000000000012345678";
//        String s = "+";
        MyAtoi myAtoi = new MyAtoi();
        int result = myAtoi.myAtoi(s);
        System.out.println(result);
    }

    public int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }
        boolean isNegative = false;
        boolean isPositive = false;
        int[] range = new int[] {0, 0};
        int index = 0;

        while (!keys.contains(s.charAt(index)) && index < s.length() - 1) {
            if (s.charAt(index) != ' ' && s.charAt(index) != '+' && s.charAt(index) != '-') { // A // -
                return 0;
            }
            if (s.charAt(index) == '+') {
                if (isPositive) {
                    return 0;
                }
                isPositive = true;
            }
            if (s.charAt(index) == '-') {
                if (isNegative) {
                    return 0;
                }
                isNegative = true;
            }
            if (isPositive && s.charAt(index) == ' ') {
                return 0;
            }
            index++;
        }
        if (isNegative && isPositive) {
            return 0;
        }
        while (s.charAt(index) == '0' && index < s.length() - 1) {
            index++;
        }
        range[0] = index;
        while (keys.contains(s.charAt(index)) && s.charAt(index) != '+' && s.charAt(index) != '-'
                && index < s.length() - 1) {
            index++;
        }
        if (!(keys.contains(s.charAt(index)) && s.charAt(index) != '+' && s.charAt(index) != '-')) {
            index--;
        }
        range[1] = index;
        if (!keys.contains(s.charAt(range[0]))) {
            return 0;
        }
        String numberStr = s.substring(range[0], range[1] + 1); // inclusive
        // get rid of proceeding zeros

        if (numberStr.length() <= 10) {
            long test = Long.parseLong(numberStr);
            if (test > Integer.MAX_VALUE) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

        }
        if (numberStr.length() >= 11) {
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        int numberInt = Integer.parseInt(numberStr);
        if (isNegative) {
            numberInt *= -1;
        }
        // 2147483647
        return numberInt;
    }

}
