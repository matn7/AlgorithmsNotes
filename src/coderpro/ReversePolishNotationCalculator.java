package coderpro;

import java.util.*;

public class ReversePolishNotationCalculator {

    public static void main(String[] args) {
        String[] operation = {"1", "2", "3", "+", "2", "*", "-"};

        ReversePolishNotationCalculator notation = new ReversePolishNotationCalculator();
        int result = notation.calc(operation);
        System.out.println(result);
        int result2 = notation.calc2(operation);
        System.out.println(result2);
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

    // O(n) time | O(n) space
    public int calc2(String[] inputs) {
        Stack<String> stack = new Stack<>();
        Map<String, Operator<Integer>> operators = new HashMap<>();
        operators.put("+", (a, b) -> a + b);
        operators.put("*", (a, b) -> a * b);
        operators.put("-", (a, b) -> a - b);
        operators.put("/", (a, b) -> a / b);

        for (String i : inputs) {
            if (operators.containsKey(i)) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                Operator<Integer> fn = operators.get(i);
                Integer val = fn.process(a, b);
                stack.push(String.valueOf(val));
            } else {
                stack.push(i);
            }
        }
        int result = Integer.parseInt(stack.pop());
        return result;
    }
}
