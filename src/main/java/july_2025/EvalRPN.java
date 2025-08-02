package july_2025;

import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class EvalRPN {

    // O(n) time | O(n) space
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Map<String, BiFunction<Integer, Integer, Integer>> ops = new HashMap<>();
        ops.put("+", (a, b) -> a + b);
        ops.put("-", (a, b) -> a - b);
        ops.put("*", (a, b) -> a * b);
        ops.put("/", (a, b) -> a / b);

        for (String token : tokens) {
            if (ops.containsKey(token)) {
                int b = stack.pop();
                int a = stack.pop();
                BiFunction<Integer, Integer, Integer> op = ops.get(token);
                stack.push(op.apply(a, b));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

}
