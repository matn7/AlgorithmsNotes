package june_2025;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class EvalRPN {

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};

        EvalRPN evalRPN = new EvalRPN();
        int result = evalRPN.evalRPN(tokens);
        System.out.println(result);

    }

    // O(n) time | O(n) space
    public int evalRPN(String[] tokens) {
        Map<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();
        operations.put("+", (a, b) -> a + b);
        operations.put("-", (a, b) -> a - b);
        operations.put("*", (a, b) -> a * b);
        operations.put("/", (a, b) -> a / b);

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (operations.containsKey(token)) {
                int b = stack.pop();
                int a = stack.pop();
                BiFunction<Integer, Integer, Integer> op = operations.get(token);
                stack.push(op.apply(a, b));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }


}
