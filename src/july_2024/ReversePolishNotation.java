package july_2024;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ReversePolishNotation {

    public static void main(String[] args) {
        String[] input = {"1", "2", "3", "+", "2", "*", "-"};
    }

    // LAMBDA - FLASHCARD

    @FunctionalInterface
    interface Operator<T> {
        T process(T a, T b);
    }

    // O(n) time | O(n) space
    public int calc(String[] inputs) {
        Stack<String> stack = new Stack<>();
        Map<String, Operator<Integer>> operators = new HashMap<>();
        operators.put("+", (a, b) -> a + b);
        operators.put("-", (a, b) -> a - b);
        operators.put("*", (a, b) -> a * b);
        operators.put("/", (a, b) -> a / b);

        for (String i : inputs) {
            if (operators.containsKey(i)) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                Operator<Integer> fn = operators.get(i);
                Integer value = fn.process(a, b);
                stack.push(String.valueOf(value));
            } else {
                stack.push(i);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
