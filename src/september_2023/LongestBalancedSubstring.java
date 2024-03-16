package september_2023;

import java.util.Stack;

public class LongestBalancedSubstring {

    public static void main(String[] args) {
        String string = "(()))(";

        LongestBalancedSubstring longestBalancedSubstring = new LongestBalancedSubstring();
        longestBalancedSubstring.longestBalancedSubstring(string);
    }

    // O(n) time | O(n) space
    public int longestBalancedSubstring(String string) {
        // Write your code here.
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int max = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    int len = i - stack.pop();
                    max = Math.max(max, len);
                }
            }
        }
        return max;
    }

}
