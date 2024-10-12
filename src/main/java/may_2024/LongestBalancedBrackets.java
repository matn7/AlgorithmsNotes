package may_2024;

import java.util.Stack;

public class LongestBalancedBrackets {

    public static void main(String[] args) {
        String str = "))((()))()()())))(())()";

        int result = longestBalancedBrackets(str);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int longestBalancedBrackets(String str) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    int len = i - stack.peek();
                    max = Math.max(max, len);
                }
            }
        }

        return max;

    }

}
