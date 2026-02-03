package january_2026;

import java.util.*;
import java.util.function.BiFunction;

public class EvaluateRPN {

    // O(n) time | O(n) space
    public int evalRPN(String[] tokens) {
        Map<String, BiFunction<Integer, Integer, Integer>> operationsMap = new HashMap<>();
        operationsMap.put("+", (a, b) -> a + b);
        operationsMap.put("-", (a, b) -> a - b);
        operationsMap.put("*", (a, b) -> a * b);
        operationsMap.put("/", (a, b) -> a / b);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (operationsMap.containsKey(token)) {
                int b = stack.removeLast();
                int a = stack.removeLast();
                BiFunction<Integer, Integer, Integer> op = operationsMap.get(token);
                stack.add(op.apply(a, b));
            } else {
                stack.addLast(Integer.parseInt(token));
            }
        }

        return stack.getLast();
    }

}
