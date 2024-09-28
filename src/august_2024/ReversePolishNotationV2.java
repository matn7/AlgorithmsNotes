package august_2024;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ReversePolishNotationV2 {

    public static void main(String[] args) {
        String[] operations = {"1", "2", "3", "+", "2", "*", "-"};

        int result = reversePolishNotation(operations);
        System.out.println(result);

    }

    // O(n) time | O(n) space
    public static int reversePolishNotation(String[] operations) {
        Map<String, Operation<Integer>> operationsMap = new HashMap<>();
        operationsMap.put("+", (a, b) -> a + b);
        operationsMap.put("-", (a, b) -> a - b);
        operationsMap.put("*", (a, b) -> a * b);
        operationsMap.put("/", (a, b) -> a / b);

        return helper(operationsMap, operations);
    }

    private static int helper(Map<String, Operation<Integer>> operationsMap, String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String operation : operations) {
            if (operationsMap.containsKey(operation)) {
                int b = stack.pop();
                int a = stack.pop();
                Operation<Integer> fn = operationsMap.get(operation);
                Integer result = fn.process(a, b);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(operation));
            }
        }
        return stack.pop();
    }


    @FunctionalInterface
    interface Operation<T> {
        T process(T a, T b);
    }

}
