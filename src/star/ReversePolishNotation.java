package star;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReversePolishNotation {

    public static void main(String[] args) {
        String[] operation = {"1", "2", "3", "+", "2", "*", "-"};

        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
        int result = reversePolishNotation.calc(operation);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int calc(String[] inputs) {
        Stack<String> stack = new Stack<>();
        Set<String> operations = new HashSet<>();
        operations.add("+");
        operations.add("-");
        operations.add("*");
        operations.add("/");
        for (String input : inputs) {
            if (operations.contains(input)) {
                Integer val2 = Integer.parseInt(stack.pop());
                Integer val1 = Integer.parseInt(stack.pop());
                if (input.equals("+")) {
                    int res = val1 + val2;
                    stack.push(String.valueOf(res));
                }
                if (input.equals("-")) {
                    int res = val1 - val2;
                    stack.push(String.valueOf(res));
                }
                if (input.equals("*")) {
                    int res = val1 * val2;
                    stack.push(String.valueOf(res));
                }
                if (input.equals("/")) {
                    int res = val1 / val2;
                    stack.push(String.valueOf(res));
                }
            } else {
                stack.push(input);
            }
        }
        return Integer.parseInt(stack.pop());
    }

}
