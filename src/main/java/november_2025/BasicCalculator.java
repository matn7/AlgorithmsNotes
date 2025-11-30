package november_2025;

import java.util.ArrayDeque;

public class BasicCalculator {

    // O(n) time | O(n) space
    public int calculate(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int currNum = 0;
        int sign = 1;
        int res = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                res += currNum * sign;
                sign = c == '-' ? -1 : 1;
                currNum = 0;
            } else if (c == '(') {
                stack.addLast(res);
                stack.addLast(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += sign * currNum;
                res *= stack.removeLast();
                res += stack.removeLast();
                currNum = 0;
            }
        }
        return res + currNum * sign;
    }

}
