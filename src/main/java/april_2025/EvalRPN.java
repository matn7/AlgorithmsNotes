package april_2025;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;
import java.util.function.Function;

public class EvalRPN {

    // O(n) time | O(n) space
    public int evalRPN(String[] tokens) {
        Map<String, BiFunction<Integer, Integer, Integer>> mapping = new HashMap<>();
        mapping.put("+", (a, b) -> a + b);
        mapping.put("-", (a, b) -> a - b);
        mapping.put("*", (a, b) -> a * b);
        mapping.put("/", (a, b) -> a / b);

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (mapping.containsKey(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int calc = mapping.get(token).apply(a, b);
                stack.push(calc);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

}
