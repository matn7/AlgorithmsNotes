package march_2025;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;
import java.util.function.Function;

public class RPN {

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};

        RPN rpn = new RPN();
        int result = rpn.evalRPN(tokens);
        System.out.println(result);
    }

    public int evalRPN(String[] tokens) {
//        Map<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();

        Map<String, Operation<Integer>> operations = new HashMap<>();
        operations.put("+", (a, b) -> a + b);
        operations.put("-", (a, b) -> a - b);
        operations.put("*", (a, b) -> a * b);
        operations.put("/", (a, b) -> a / b);

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (operations.containsKey(token)) {
                int b = stack.pop();
                int a = stack.pop();
//                stack.push(operations.get(token).apply(a, b));
                stack.push(operations.get(token).calculate(a, b));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }

    @FunctionalInterface
    interface Operation<T> {
        T calculate(T a, T b);
    }


}
