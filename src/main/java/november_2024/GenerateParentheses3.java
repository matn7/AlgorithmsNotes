package november_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses3 {

    public static void main(String[] args) {
        int n = 3;

        GenerateParentheses3 generateParentheses = new GenerateParentheses3();
        List<String> result = generateParentheses.generateParenthesis(n);
        System.out.println(result);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        generateParenthesisHelper(n, n, stack, result);
        return result;
    }

    private void generateParenthesisHelper(int open, int close, Stack<String> stack, List<String> result) {
        // If no more open or close parentheses left to add, check the stack
        if (open == 0 && close == 0) {
            StringBuilder sb = new StringBuilder();
            for (String s : stack) {
                sb.append(s);  // Construct the current valid parentheses string
            }
            result.add(sb.toString());  // Add the valid combination to the result list
            return;
        }

        // If we have open parentheses left to add
        if (open > 0) {
            stack.push("(");  // Add an open parenthesis to the stack
            generateParenthesisHelper(open - 1, close, stack, result);  // Recurse with one less open parenthesis
            stack.pop();  // Backtrack: remove the last open parenthesis
        }

        // If we can still add a close parenthesis
        if (close > open) {
            stack.push(")");  // Add a close parenthesis to the stack
            generateParenthesisHelper(open, close - 1, stack, result);  // Recurse with one less close parenthesis
            stack.pop();  // Backtrack: remove the last close parenthesis
        }
    }
}

