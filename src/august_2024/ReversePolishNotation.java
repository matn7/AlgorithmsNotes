package august_2024;

import java.util.*;
import java.util.function.BiFunction;

public class ReversePolishNotation {

    public static void main(String[] args) {
        String[] operations = {"1", "2", "3", "+", "2", "*", "-"};

        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
        int result = reversePolishNotation.calculate(operations);
        System.out.println(result);
    }

    static final Map<String, BiFunction<Integer, Integer, Integer>> op = new HashMap<>();
    static {
        op.put("+", (a, b) -> a + b);
        op.put("-", (a, b) -> a - b);
        op.put("*", (a, b) -> a * b);
        op.put("/", (a, b) -> a / b);
    }

    // O(n) time | O(n) space
    public int calculate(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String operation : operations) {
            if (op.containsKey(operation)) {
                int b = stack.pop();
                int a = stack.pop();
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                BiFunction<Integer, Integer, Integer> fn = op.get(operation);
                int res = fn.apply(a, b);
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(operation));
            }
        }
        return stack.pop();
    }

}
