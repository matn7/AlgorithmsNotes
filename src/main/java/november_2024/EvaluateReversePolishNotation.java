package november_2024;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        EvaluateReversePolishNotation reversePolishNotation = new EvaluateReversePolishNotation();
        int result = reversePolishNotation.evalRPN(tokens);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
//        Map<String, Operation<Integer>> operationMap = new HashMap<>();
        Map<String, BiFunction<Integer, Integer, Integer>> operationMap = new HashMap<>();
        operationMap.put("+", (a, b) -> a + b);
        operationMap.put("-", (a, b) -> a - b);
        operationMap.put("*", (a, b) -> a * b);
        operationMap.put("/", (a, b) -> a / b);

        for (String token : tokens) {
            if (operationMap.containsKey(token)) {
                Integer b = stack.pop();
                Integer a = stack.pop();
                BiFunction<Integer, Integer, Integer> fn = operationMap.get(token);
                Integer result = fn.apply(a, b);
                stack.push(result);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

//    @FunctionalInterface
//    interface Operation<T> {
//        T process(T a, T b);
//    }

}
