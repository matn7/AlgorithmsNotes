package coderpro;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReversePolishNotationCalculator {

    public static void main(String[] args) {
        String[] operation = {"1", "2", "3", "+", "2", "*", "-"};

        ReversePolishNotationCalculator notation = new ReversePolishNotationCalculator();
        int result = notation.calc(operation);
        System.out.println(result);
    }

    // ********
    // * STAR *
    // ********

    // O(n) time | O(n) space
    public int calc(String[] inputs) {
        Stack<String> stack = new Stack<>();
        Set<String> operators = new HashSet<>();
        operators.add("-");
        operators.add("+");
        operators.add("*");
        operators.add("/");
        for (String i : inputs) {
            if (operators.contains(i)) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                if (i.equals("-")) {
                    int val = a - b;
                    stack.push(String.valueOf(val));
                }
                if (i.equals("+")) {
                    int val = a + b;
                    stack.push(String.valueOf(val));
                }
                if (i.equals("*")) {
                    int val = a * b;
                    stack.push(String.valueOf(val));
                }
                if (i.equals("/")) {
                    int val = a / b;
                    stack.push(String.valueOf(val));
                }
            } else {
                stack.push(i);
            }
        }
        int result = Integer.parseInt(stack.pop());
        return result;

    }

}
