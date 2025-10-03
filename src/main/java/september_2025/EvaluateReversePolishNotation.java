package september_2025;

import java.nio.file.StandardOpenOption;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        int result = evaluateReversePolishNotation.evalRPN(tokens);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int evalRPN(String[] tokens) {
        Map<String, BiFunction<Integer, Integer, Integer>> evalMap = new HashMap<>();
        evalMap.put("+", (a, b) -> a + b);
        evalMap.put("-", (a, b) -> a - b);
        evalMap.put("*", (a, b) -> a * b);
        evalMap.put("/", (a, b) -> a / b);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (evalMap.containsKey(token)) {
                int b = stack.removeFirst();
                int a = stack.removeFirst();
                int sum = evalMap.get(token).apply(a, b);
                stack.addFirst(sum);
            } else {
                stack.addFirst(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
