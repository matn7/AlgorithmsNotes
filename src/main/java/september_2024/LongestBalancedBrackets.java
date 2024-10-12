package september_2024;

import java.util.Stack;

public class LongestBalancedBrackets {

    public static void main(String[] args) {
        String str = "(())()(";

        int result = longestBrackets(str);
        System.out.println(result);
    }

    public static int longestBrackets(String str) {
        if (str.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;
        for (int idx = 0; idx < str.length(); idx++) {
            char current = str.charAt(idx);
            if (current == '(') {
                stack.push(idx);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(idx);
                } else {
                    Integer peek = stack.peek();
                    int currLen = idx - peek;
                    maxLen = Math.max(maxLen, currLen);
                }
            }
        }
        return maxLen;
    }

}
