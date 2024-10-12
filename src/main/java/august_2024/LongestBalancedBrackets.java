package august_2024;


import java.util.Stack;

public class LongestBalancedBrackets {

    public static void main(String[] args) {
        String str = "(()))(";

        int result = longestBalancedSubstr(str);
        System.out.println(result);

    }

    // O(n) time | O(n) space
    public static int longestBalancedSubstr(String str) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int max = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
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
