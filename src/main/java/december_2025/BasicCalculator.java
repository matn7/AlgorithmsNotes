package december_2025;

import java.util.ArrayDeque;

public class BasicCalculator {

    public int calculate(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int curNum = 0;
        int sign = 1;
        int res = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                curNum = curNum * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                res += curNum * sign;
                sign = c == '-' ? -1 : 1;
                curNum = 0;
            } else if (c == '(') {
                stack.addLast(res);
                stack.addLast(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += sign * curNum;
                res *= stack.removeLast();
                res += stack.removeLast();
                curNum = 0;
            }
        }

        return res + curNum * sign;
    }

}
